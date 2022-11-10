import java.util.ArrayList;

public class Appointments
{
	private String date;
	public Appointments(String newDate)
	{
		date = newDate;
	}
	public void setAppointment(String newDate)
	{
		date = newDate;
	}
	public void cancelAppointment(String cancelDate)
	{
		for(int i = 0; i < Client.appointments.size(); i++)
		{
			if(Client.appointments.get(i).contains(cancelDate))
			{
				Client.appointments.remove(Client.appointments.get(i));
			}
		}
		System.out.println("Appointment has been cancelled");
	}
	public void checkAppointment(String date)
	{
		for(int i = 0; i < Client.appointments.size(); i++)
		{
			if(Client.appointments.get(i).contains(date))
			{
				System.out.println("Appointment is taken. Choose a different date.");
			}
			else 
			{
				System.out.println("Appointment has been made.");
			}
		}
	}

}
