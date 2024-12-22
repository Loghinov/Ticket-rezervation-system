package org.example.dao.Impl;

import org.example.configuration.DataBaseConfig;
import org.example.dao.AirportDao;
import org.example.entity.Airport;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
@Repository
public class AirportDaoImpl extends AbstractDaoImpl<Airport> implements AirportDao {
    public AirportDaoImpl(DataBaseConfig config) {
        super(config);
    }

    @Override
    public Airport getByCode(long airlineCode) {
        String query = "Select * from airport where airport_id=?";
        Airport airport=null;
        try (PreparedStatement statement = getConnection().prepareStatement(query)){
            statement.setLong(1, airlineCode);
            ResultSet resultSet = statement.executeQuery();
            if(resultSet.next()){
                long airportId=resultSet.getLong("airport_id");
                String airportName = resultSet.getString("airport_name");
                String airportCity = resultSet.getString("airport_city");
                String airportCountry= resultSet.getString("airport_country");
                airport=new Airport(airportId, airlineCode, airportName, airportCity, airportCity);
            }
            return airport;
        }catch (SQLException e){
            throw  new RuntimeException("Error at airport get by airort code");
        }
    }

    @Override
    public Airport getById(long id) {
        String query="Select * from airport where airport_id=?";
        try(PreparedStatement statement=getConnection().prepareStatement(query)){
            statement.setLong(1,id);
            ResultSet resultSet= statement.executeQuery();
            if(resultSet.next()){
                return new Airport(
                        resultSet.getLong("airport_id"),
                        resultSet.getLong("airport_id"),
                        resultSet.getString("airport_name"),
                        resultSet.getString("airport_city"),
                        resultSet.getString("airport_country")
                );
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Airport> getAll() {
        String query="Select * from airport";
        List<Airport> airports=new ArrayList<>();
        try (PreparedStatement statement=getConnection().prepareStatement(query)){
            ResultSet resultSet = statement.executeQuery();
            while(resultSet.next()){
                long airportId = resultSet.getLong("airport_id");
                long airportCode = resultSet.getLong("airport_id");
                String airportName = resultSet.getString("airport_name");
                String airportCity = resultSet.getString("airport_city");
                String airportCountry = resultSet.getString("airport_country");
                airports.add(new Airport(airportId,airportCode,airportName,airportCity,airportCountry));
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return (airports);
    }

    @Override
    public Airport save(Airport airport) {
        String query ="Select into airport(airport_code, airport_name, airport_city, airport_country ) values(?,?,?,?)";
        try(PreparedStatement statement = getConnection().prepareStatement(query)){
            statement.setLong(1, airport.getAirportCode());
            statement.setString(2, airport.getAirportName());
            statement.setString(3, airport.getAirportCity());
            statement.setString(4, airport.getAirportCountry());

            int rowsAffected = statement.executeUpdate();
            if(rowsAffected>0){
                System.out.println("Airport saved successfully");
                return  airport;
            }else{
                System.out.println("Failed to save airport");
                return airport;
            }
        } catch (Exception e) {
            throw new RuntimeException("Error while saving airport to the database");
        }
    }

    @Override
    public Airport update(Airport airport, String params) {
        String query = "UPDATE airport SET airport_code = ? WHERE airport_id = ?";
        try (PreparedStatement statement = getConnection().prepareStatement(query)){
            statement.setLong(1, Long.parseLong(params));
            statement.setLong(2, airport.getAirportId());
            statement.executeUpdate();
            airport.setAirportCode(Long.parseLong(params));
            return airport;
        } catch (Exception e) {
            throw new RuntimeException("Errror to update");
        }
    }

    @Override
    public String delete(Airport airport) {
        String query ="Select * from airport where airport_id=?";
        try (PreparedStatement statement = getConnection().prepareStatement(query)) {
            statement.setLong(1, airport.getAirportId());
            int rowsaAffected = statement.executeUpdate();
            if (rowsaAffected>0){
                return "Airport deleted successfully";
            }else{
                return ("Error  to delete airport");
            }
        } catch (Exception e) {
            throw new RuntimeException("Error while deleting airport from the database");
        }
    }
}

