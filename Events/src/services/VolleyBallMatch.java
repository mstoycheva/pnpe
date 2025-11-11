package services;

public class VolleyBallMatch extends Event {
    protected String firstTeam;
    protected String secondTeam;

    public VolleyBallMatch(String place, String date, String startHour, int numberOfTickets, double priceOfTicket, String firstTeam, String secondTeam) {
        super(place, date, startHour, numberOfTickets, priceOfTicket);
        this.firstTeam = firstTeam;
        this.secondTeam = secondTeam;
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
