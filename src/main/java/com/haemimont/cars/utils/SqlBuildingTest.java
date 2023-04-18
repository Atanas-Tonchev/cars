package com.haemimont.cars.utils;

public class SqlBuildingTest {




    private String sql = "SELECT " +
            "car_id,height,length,width,drive_line,engine_type,hybrid,transmission," +
            "number_of_forward_gears,horsepower,torque,fuel_type," +
            "city_mpg,highway_mpg,classification,identification.id,make,model_year,identification.year " +
            "FROM " +
            "csv_cars_db.car " +
            "INNER JOIN " +
            "csv_cars_db.dimensions " +
            "ON " +
            "dimensions.dimensions_id = car.dimensions_dimensions_id " +
            "INNER JOIN " +
            "csv_cars_db.engine_information " +
            "ON " +
            "engine_information.engine_information_id = car.engine_information_engine_information_id " +
            "INNER JOIN " +
            "csv_cars_db.engine_statistics " +
            "ON " +
            "engine_statistics.engine_statistics_id = engine_information.engine_statistics_engine_statistics_id " +
            "INNER JOIN " +
            "csv_cars_db.fuel_information " +
            "ON " +
            "fuel_information.fuel_information_id = car.fuel_information_fuel_information_id " +
            "INNER JOIN " +
            "csv_cars_db.identification " +
            "ON " +
            "identification.identification_id = car.identification_identification_id";

    private boolean isWhere = false;
    private String clause = " where ";

    private String checkClause(){
        if(!isWhere) {
            isWhere = true;
            return clause;
        }else {
            clause = " and ";
        }
        return clause;
    }

    public String equalsParam(String dbColumnName,Object param){
        return sql += checkClause()+dbColumnName+ " = ? ";

    }
    public String greatherThanParam(String dbColumnName,Object param){
        return sql += checkClause()+dbColumnName+ " >= ? ";
    }
    public String lessThanParam(String dbColumnName,Object param){
        return sql += checkClause()+dbColumnName+ " <= ? " ;
    }

    public String getSql() {
        return sql;
    }

    public static void main(String[] args){
        SqlBuildingTest sqlBuildingTest = new SqlBuildingTest();

        String make = "";
        int yearF = 2009;
        int yearT = 2010;

        if(make != null && !make.equals("")){
            sqlBuildingTest.equalsParam("identification.make",make);

        }
        if(yearF!=0){
            sqlBuildingTest.greatherThanParam("identification.year",yearF);
        }
        if(yearT!=0){
            sqlBuildingTest.lessThanParam("identification.year",yearT);
        }
        System.out.println(sqlBuildingTest.getSql());

    }
}
