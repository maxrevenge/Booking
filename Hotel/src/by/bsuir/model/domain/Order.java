package by.bsuir.model.domain;


public class Order {
   
    private int orderId;
    private int guests;
    private String arrivalDate;
    private String departureDate;
    private String login;
    private long orderPrice;



    public Order() {
    }

    public Order(int guests, String arrivalDate, String departureDate, String login, long orderPrice) {
        this.guests = guests;
        this.arrivalDate = arrivalDate;
        this.departureDate = departureDate;
        this.login = login;
        this.orderPrice = orderPrice;
    }

    public Order(int guests, String arrivalDate, String departureDate, String login) {
        this.guests = guests;
        this.arrivalDate = arrivalDate;
        this.departureDate = departureDate;
        this.login = login;
        this.orderPrice = orderPrice;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Order order = (Order) o;

        if (orderId != order.orderId) return false;
        if (guests != order.guests) return false;
        if (orderPrice != order.orderPrice) return false;
        if (arrivalDate != null ? !arrivalDate.equals(order.arrivalDate) : order.arrivalDate != null) return false;
        if (departureDate != null ? !departureDate.equals(order.departureDate) : order.departureDate != null)
            return false;
        return !(login != null ? !login.equals(order.login) : order.login != null);

    }

    @Override
    public int hashCode() {
        int result = orderId;
        result = 31 * result + guests;
        result = 31 * result + (arrivalDate != null ? arrivalDate.hashCode() : 0);
        result = 31 * result + (departureDate != null ? departureDate.hashCode() : 0);
        result = 31 * result + (login != null ? login.hashCode() : 0);
        result = 31 * result + (int) (orderPrice ^ (orderPrice >>> 32));
        return result;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getGuests() {
        return guests;
    }

    public void setGuests(int guests) {
        this.guests = guests;
    }

    public String getArrivalDate() {
        return arrivalDate;
    }

    public void setArrivalDate(String arrivalDate) {
        this.arrivalDate = arrivalDate;
    }

    public String getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(String departureDate) {
        this.departureDate = departureDate;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public long getOrderPrice() {
        return orderPrice;
    }

    public void setOrderPrice(int orderPrice) {
        this.orderPrice = orderPrice;
    }
}
