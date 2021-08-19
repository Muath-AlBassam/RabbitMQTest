package sa.gov.sfd.rabbitMQTest;

public class AttendanceDTO {

    private long userNID;
    private String dateAg;
    private String dateAh;
    private String timeIn;
    private String timeOut;


    public AttendanceDTO() {
    }

    public AttendanceDTO(long userNID, String dateAg, String dateAh, String timeIn, String timeOut) {
        this.userNID = userNID;
        this.dateAg = dateAg;
        this.dateAh = dateAh;
        this.timeIn = timeIn;
        this.timeOut = timeOut;
    }

    public long getUserNID() {
        return this.userNID;
    }

    public void setUserNID(long userNID) {
        this.userNID = userNID;
    }

    public String getDateAg() {
        return this.dateAg;
    }

    public void setDateAg(String dateAg) {
        this.dateAg = dateAg;
    }

    public String getDateAh() {
        return this.dateAh;
    }

    public void setDateAh(String dateAh) {
        this.dateAh = dateAh;
    }

    public String getTimeIn() {
        return this.timeIn;
    }

    public void setTimeIn(String timeIn) {
        this.timeIn = timeIn;
    }

    public String getTimeOut() {
        return this.timeOut;
    }

    public void setTimeOut(String timeOut) {
        this.timeOut = timeOut;
    }


    @Override
    public String toString() {
        return "{" +
            " userNID='" + getUserNID() + "'" +
            ", dateAg='" + getDateAg() + "'" +
            ", dateAh='" + getDateAh() + "'" +
            ", timeIn='" + getTimeIn() + "'" +
            ", timeOut='" + getTimeOut() + "'" +
            "}";
    }


}
