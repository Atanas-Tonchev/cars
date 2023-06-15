package com.haemimont.cars.funny;

public class Jokes {
    String type;
    String setup;
    String punchline;
    int id;

    public Jokes(String type, String setup, String punchline, int id) {
        this.type = type;
        this.setup = setup;
        this.punchline = punchline;
        this.id = id;
    }

    public String getSetup() {
        return setup;
    }

    public String getPunchline() {
        return punchline;
    }

    @Override
    public String toString() {
        return "Jokes{" +
                "type='" + type + '\'' +
                ", setup='" + setup + '\'' +
                ", punchline='" + punchline + '\'' +
                ", id=" + id +
                '}';
    }
    /* public List<String> connectUrl() {
        BufferedReader br;
        String line;
        StringBuilder responseContent = new StringBuilder();
        String setup = null;
        String end = null;
        String str = null;
        List<String> list1 = new ArrayList<>();
        try {
            URL url1 = new URL("https://official-joke-api.appspot.com/random_joke");
            HttpURLConnection httpURLConnection = (HttpURLConnection) url1.openConnection();

            // Request setup
            httpURLConnection.setRequestMethod("GET");
            int status = httpURLConnection.getResponseCode();
            // System.out.println(status);
            if (status > 299) {
                br = new BufferedReader(new InputStreamReader(httpURLConnection.getErrorStream()));
                while ((line = br.readLine()) != null) {
                    responseContent.append(line);
                }
                br.close();

            } else {
                br = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream()));
                while ((line = br.readLine()) != null) {
                    responseContent.append(line);
                }
                br.close();
            }
             str = responseContent.toString();
            String[] arrOfStr = str.split(",");
            List<String> list = new ArrayList<>(Arrays.asList(arrOfStr));
            String a = list.get(1);
            String[] arr = a.split(":");
            for (String ab : arr) {
                String[] s = ab.split("\"setup\"");
                //setup = aaa;
                list1.addAll(Arrays.asList(s));
            }
            String b = list.get(2);
            String[] arrb = b.split(":");
            for (String ab : arrb) {
                String[] s = ab.split("\"punchline\"");
                //end = aaa;
                list1.addAll(Arrays.asList(s));
            }
            httpURLConnection.disconnect();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        String result = setup + "\n" + end;
        System.out.println(list1);
        return list1;
    }*/
}
