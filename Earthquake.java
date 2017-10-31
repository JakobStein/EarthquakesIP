
/**
 * A class of earthquakes of a given magnitude(on the Richter local magnitude scale) with coordinates given in latitude and longitude.
 * Also recorded is the year the earthquake occured in, as well as the name of the earthquake, if it
 * was particularly well-known.
 * 
 * 
 * @jakobstein
 * @v1.0
 * 2013
 */
public class Earthquake
{
    private double magnitude;
    private double latitude;
    private double longitude;
    private int yearofevent;
    private String earthquakename;

    public Earthquake(double magnitude, double latitude, double longitude, int yearofevent) 
    {this.magnitude= magnitude; 
        this.longitude=longitude;
        this.latitude=latitude;
        this.yearofevent=yearofevent;

    }

    public double getMagnitude()
    {return magnitude;}

    public double getLatitude()
    {return latitude;}

    public double getLongitude()
    {return longitude;}

    public int getYearofEvent()
    {return yearofevent;}

    public void setName(String y)
    {earthquakename=y;}

}
