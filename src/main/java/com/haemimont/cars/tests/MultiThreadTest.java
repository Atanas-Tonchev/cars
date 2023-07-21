package com.haemimont.cars.tests;
import com.haemimont.cars.api.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class MultiThreadTest {
    private static final Logger logger = LogManager.getLogger(MultiThreadTest.class);
    private static final UnitTestApi test = new UnitTestApi();
    private static final ReentrantLock rel = new ReentrantLock();
    private final Lock lock = new ReentrantLock();

    public void getThreadTestApi(ApiObjectUtil objectUtil) throws InterruptedException {
        Thread connection = new Thread(() -> {
            lock.lock();
            try {
                test.connectionThread();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }finally {
                lock.unlock();
            }
        });
        connection.start();
        Thread registration = new Thread(() -> {
            lock.lock();
            try {
                test.registrationThread(objectUtil);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }finally {
                lock.unlock();
            }
        });
        registration.start();
        Thread login = new Thread(() -> {
            lock.lock();
            try {
                test.loginThread(objectUtil);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }finally {
                lock.unlock();
            }
        });
        login.start();
        Thread auth = new Thread(() -> {
            lock.lock();
            try {
                test.authThread();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }finally {
                lock.unlock();
            }
        });
        auth.start();
        connection.join();
        registration.join();
        login.join();
        auth.join();
    }

    public void getThreadTestApiInnerLock(ApiObjectUtil apiObjectUtil) {

        ExecutorService pool
                = Executors.newFixedThreadPool(4);
        Thread connection = new Thread(() -> {
            boolean done = false;
            while (!done) {
                // Getting Outer Lock
                boolean ans = rel.tryLock();

                // Returns True if lock is free
                if (ans) {
                    try {
                        logger.info("Testing connection....");
                        Thread.sleep(1000);

                        // Getting Inner Lock
                        rel.lock();
                        try {
                            test.connectionThread();
                        } catch (Exception e) {
                            throw new RuntimeException(e);
                        } finally {
                            // Inner lock release
                            logger.info("connection thread releasing inner lock");

                            rel.unlock();
                        }
                        logger.info("connection thread test done");

                        done = true;
                    }
                    catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    finally {
                        // Outer lock release
                        logger.info("connection thread releasing outer lock");

                        rel.unlock();
                    }
                }
                else {
                    logger.info("connection thread waiting for test");
                    try {
                        Thread.sleep(1000);
                    }
                    catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        Thread registration = new Thread(() -> {
            boolean done = false;
            while (!done) {
                // Getting Outer Lock
                boolean ans = rel.tryLock();

                // Returns True if lock is free
                if (ans) {
                    try {
                        logger.info("Testing registration...");
                        Thread.sleep(1000);

                        // Getting Inner Lock
                        rel.lock();
                        try {
                            test.registrationThread(apiObjectUtil);
                        } catch (Exception e) {
                            throw new RuntimeException(e);
                        } finally {
                            // Inner lock release
                            logger.info("registration thread releasing inner lock");

                            rel.unlock();
                        }
                        logger.info("registration thread test done");

                        done = true;
                    }
                    catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    finally {
                        // Outer lock release
                        logger.info("registration thread releasing outer lock");

                        rel.unlock();
                    }
                }
                else {
                    logger.info("registration thread waiting for test");
                    try {
                        Thread.sleep(1000);
                    }
                    catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        Thread login = new Thread(() -> {
            boolean done = false;
            while (!done) {
                // Getting Outer Lock
                boolean ans = rel.tryLock();

                // Returns True if lock is free
                if (ans) {
                    try {
                        logger.info("Testing login...");
                        Thread.sleep(1000);

                        // Getting Inner Lock
                        rel.lock();
                        try {
                            test.loginThread(apiObjectUtil);
                        } catch (Exception e) {
                            throw new RuntimeException(e);
                        } finally {
                            // Inner lock release
                            logger.info("login thread releasing inner lock");

                            rel.unlock();
                        }
                        logger.info("login thread test done");

                        done = true;
                    }
                    catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    finally {
                        // Outer lock release
                        logger.info("login thread releasing outer lock");

                        rel.unlock();
                    }
                }
                else {
                    logger.info("login thread waiting for test");
                    try {
                        Thread.sleep(1000);
                    }
                    catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        Thread auth = new Thread(() -> {
            boolean done = false;
            while (!done) {
                // Getting Outer Lock
                boolean ans = rel.tryLock();

                // Returns True if lock is free
                if (ans) {
                    try {
                        logger.info("Testing authentication...");
                        Thread.sleep(1000);

                        // Getting Inner Lock
                        rel.lock();
                        try {
                            test.authThread();
                        } catch (Exception e) {
                            throw new RuntimeException(e);
                        } finally {
                            // Inner lock release
                            logger.info("auth thread releasing inner lock");

                            rel.unlock();
                        }
                        logger.info("auth thread test done");

                        done = true;
                    }
                    catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    finally {
                        // Outer lock release
                        logger.info("auth thread releasing outer lock");

                        rel.unlock();
                    }
                }
                else {
                    logger.info("auth thread waiting for test");
                    try {
                        Thread.sleep(1000);
                    }
                    catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        pool.execute(connection);
        pool.execute(registration);
        pool.execute(login);
        pool.execute(auth);
        pool.shutdown();
    }

    public static void main(String[] args) throws InterruptedException {
        String username = "Atanas1990";
        String pass = "betimoni2215";
        String email = "rrrrrrrsjsf@example.com";
        List<String> userRoles = new ArrayList<>();
        userRoles.add(UserRole.MODERATOR);
        userRoles.add(UserRole.USER);
        ApiObjectUtil req = new ApiObjectUtil(new ApiRegistration(username,pass,email, userRoles),
                new ApiLogin(username,pass),
                new ApiAuthorization());

        MultiThreadTest test = new MultiThreadTest();
        test.getThreadTestApiInnerLock(req);
        //test.getThreadTestApi(req);

    }
}
