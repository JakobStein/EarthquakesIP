import java.util.ArrayList; 
import java.util.Collections;

/**
 * A class that performs meta-analysis of the data collected by multiple observatories. 
 *
 *@jakobstein
 *@v1.0
 *2014
 */

public class Monitoring
{
    private ArrayList<Observatory> monitor;

    public Monitoring()
    {
        monitor=new ArrayList<Observatory>();
    }

    public void assignObservatory(Observatory o)
    {monitor.add(o);}

    public ArrayList<Earthquake> metalargerthan(int min)
    {ArrayList<Earthquake> list = new ArrayList<Earthquake>();
        for(Observatory o:monitor)
        {list.addAll(o.largerthan(min));}
        return list;
    }

    public Observatory observatoryavMax()
    { ArrayList<Double> list1 = new ArrayList<>();
        ArrayList<Observatory> list2 = new ArrayList<Observatory>(monitor);

        for(Observatory o:monitor)
        {list1.add(o.avmag());}

        for(Observatory o:list2)
        {if(o.avmag()==Collections.max(list1))
            {return o;}
        }

        return monitor.get(0);
    }

    public Observatory minavpa()
    {ArrayList<Double> list1 = new ArrayList<>();
        ArrayList<Observatory> list2 = new ArrayList<Observatory>(monitor);
        for(Observatory o:monitor)
        {list1.add(o.avquakepa());}

        for(Observatory o:list2)
        {if(o.avquakepa()==Collections.min(list1))
            {return o;}
        }
        return monitor.get(0);
    }

    public Earthquake metamagmax()
    {Observatory list1 = new Observatory(0,0,"x");
        for(Observatory o:monitor)
        {list1.assignEarthquake(o.magmax());}
        return list1.magmax(); 

    }

    public static void testMonitor()
    {
        Monitoring metatest= new Monitoring();
        Observatory testcase1= new Observatory(2008, 2, "test1");
        testcase1.addEarthquake(1, 53, 50, 2010);
        testcase1.addEarthquake(3, 53, 50, 2009);
        testcase1.addEarthquake(5, 53, 50, 2008);
        metatest.assignObservatory(testcase1);
        Observatory testcase2= new Observatory(2005, 2, "test2");
        testcase2.addEarthquake(2, 54, 50 , 2008);
        testcase2.addEarthquake(4, 54, 50, 2007);
        testcase2.addEarthquake(6, 54, 50, 2006);
        testcase2.addEarthquake(4, 54, 50, 2005);
        metatest.assignObservatory(testcase2);
        Observatory testcase3= new Observatory(2002, 2, "test3");
        testcase3.addEarthquake(3, 53, 50, 2004);
        testcase3.addEarthquake(5, 53, 50, 2003);
        testcase3.addEarthquake(7, 53, 50, 2002);
        metatest.assignObservatory(testcase3);
        System.out.println("1.metamagmax 2.metalargerthan 3.minavpa 4.observatoryavMax");
        if(metatest.metamagmax().getMagnitude()==7)
        {System.out.println("pass");}
        else
        {System.out.println("fail");}
        if(metatest.metalargerthan(6).get(0).getMagnitude()==7)
        {System.out.println("pass");}
        else
        {System.out.println("fail");}
        if(metatest.minavpa().getName()=="test3")
        {System.out.println("pass");}
        else
        {System.out.println("fail");}
        if(metatest.observatoryavMax().getName()=="test3")
        {System.out.println("pass");}
        else
        {System.out.println("fail");}

    }
}
