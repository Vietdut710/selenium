package Common.Object;

public class TicketInfo {
    private String departDate;
    private String departStation;
    private String departArrive;
    private String seatType;
    private String amountTicket;

    public String getDepartDate() {
        return departDate;
    }

    public void setDepartDate(String departDate) {
        this.departDate = departDate;
    }

    public String getDepartStation() {
        return departStation;
    }

    public void setDepartStation(String departStation) {
        this.departStation = departStation;
    }

    public String getDepartArrive() {
        return departArrive;
    }

    public void setDepartArrive(String departArrive) {
        this.departArrive = departArrive;
    }

    public String getSeatType() {
        return seatType;
    }

    public void setSeatType(String seatType) {
        this.seatType = seatType;
    }

    public String getAmountTicket() {
        return amountTicket;
    }

    public void setAmountTicket(String amountTicket) {
        this.amountTicket = amountTicket;
    }
}
