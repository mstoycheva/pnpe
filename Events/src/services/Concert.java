package services;

public class Concert extends Event {
    protected String starName;

    public Concert(String place, String date, String startHour, int numberOfTickets, double priceOfTicket, String starName) {
        super(place, date, startHour, numberOfTickets, priceOfTicket);
        this.starName = starName;
    }


    @Override
    public boolean sellTicket(int num) {
        try {
            if(num > numberOfTickets) {
                return false;
            } else {
                numberOfTickets-=num;
            }
        } catch (NoMoreTicketException e) {
            e.getMessage();
        }
        return true;
    }
}
