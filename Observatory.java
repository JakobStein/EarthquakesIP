import java.util.ArrayList; 
import java.util.Calendar;
import java.util.Collections;

/**
 * A class of observatories that have a country which they are recording in, a date of foundation, 
 * an area(in square kilometers) in which the measure earthquakes, and of course, a list of 
 * the earthquakes which they have recorded.
 * 
 * @jakobstein 
 * @v1.0
 * 2014
 */
public class Observatory
{
    private String obsname;
    private String country;
    private int obsyear;
    private double area;
    private ArrayList<Earthquake> quakerec;

    public Observatory(int yearoffoundation, double sqkm, String name)
    {   quakerec=new ArrayList<Earthquake>();

        obsyear= yearoffoundation;
        area= sqkm;
        obsname=name;
    }

    public void addEarthquake(double magnitude, double latitude, double longitude, int yearofevent)
    { Earthquake m= new Earthquake(magnitude, latitude, longitude, yearofevent);
        quakerec.add(m);

    }

    public void assignEarthquake(Earthquake m)
    {quakerec.add(m);
    }

    public void assignEarthquakes(ArrayList<Earthquake> m)
    {quakerec.addAll(m);
    }

    public void setCountry(String s)
    {country=s;
    }

    public int getAge()
    {

        Calendar cal = Calendar.getInstance();

        return cal.get(Calendar.YEAR)-obsyear;

    }

    public String getName()
    {return obsname;}

    public double avquakepa()
    {
        double s = getAge();
        return quakerec.size()/s;
    }

    public double avmag()
    {if(quakerec.size()!=0)
        {
            double t = 0;

            for(Earthquake m : quakerec)
            {t=t+m.getMagnitude();}

            return t/quakerec.size();}
        else
        {System.out.println("No earthquakes recorded");
            return 0;}

    }

    public ArrayList<Earthquake> largerthan(int min)
    { ArrayList<Earthquake> list = new ArrayList<Earthquake>(quakerec);
        for(Earthquake m: quakerec) 
        {if(m.getMagnitude()<=min)
            {list.remove(m);};}
        return list;
    }

    public Earthquake magmax()
    {  
        ArrayList<Earthquake> list1 = new ArrayList<Earthquake>(quakerec);
        ArrayList<Double> list2 = new ArrayList<>();

        for(Earthquake m: quakerec)
        {list2.add(m.getMagnitude());}

        for(Earthquake m: list1) 
        {if(m.getMagnitude()==Collections.max(list2))
            {return m;}}

        return quakerec.get(0);

    }

    static public void testObservatory()
    {Observatory testcase= new Observatory(2011, 2, "test");
        testcase.addEarthquake(1, 53, 50, 2010);
        testcase.addEarthquake(3, 53, 50, 2009);
        testcase.addEarthquake(5, 53, 50, 2008);
        System.out.println("1.magmax 2.largerthan 3.avmag 4.avquakepa") ;

        if(testcase.magmax().getMagnitude()==5)
        {System.out.println("pass");}
        else
        {System.out.println("fail");}
        if(testcase.largerthan(4).get(0).getYearofEvent()==2008)
        {System.out.println("pass");}
        else
        {System.out.println("fail");}

        if(testcase.avmag()==3)
        {System.out.println("pass");}
        else
        {System.out.println("fail");}
        if(testcase.avquakepa()==1)
        {System.out.println("pass");}
        else
        {System.out.println("fail");}
    }

}
