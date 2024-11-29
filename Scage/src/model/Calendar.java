package model;

public class Calendar {
    private String year;
    private String month;
    private String day;
    private String category;
    private String date;

    public Calendar(String year, String month, String day, String category, String date) {
        this.year = year;
        this.month = month;
        this.day = day;
        this.category = category;
        this.date = date;
    }

    public String getYear() {
        return year;
    }

    public String getMonth() {
        return month;
    }

    public String getDay() {
        return day;
    }

    public String getCategory() {
        return category;
    }

    public String getDate() {
        return date;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
