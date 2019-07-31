package com.Medicine.SkyForceTeam;

import java.util.Calendar;
import java.util.List;

public class remainder_data {
    private String cure_name;
    private String remaind_times;
    private  boolean IsEnable;
    private Calendar Start_date;
    private Calendar End_date;
    private List<Calendar> remainders;

    public remainder_data(String cure_name, String remaind_times, boolean isEnable) {
        this.cure_name = cure_name;
        this.remaind_times = remaind_times;
        IsEnable = isEnable;
    }

    public String getCure_name() {
        return cure_name;
    }

    public void setCure_name(String cure_name) {
        this.cure_name = cure_name;
    }

    public String getRemaind_times() {
        return remaind_times;
    }

    public void setRemaind_times(String remaind_times) {
        this.remaind_times = remaind_times;
    }

    public boolean isEnable() {
        return IsEnable;
    }

    public void setEnable(boolean enable) {
        IsEnable = enable;
    }

    public Calendar getStart_date() {
        return Start_date;
    }

    public void setStart_date(Calendar start_date) {
        Start_date = start_date;
    }

    public Calendar getEnd_date() {
        return End_date;
    }

    public void setEnd_date(Calendar end_date) {
        End_date = end_date;
    }

    public List<Calendar> getRemainders() {
        return remainders;
    }

    public void setRemainders(List<Calendar> remainders) {
        this.remainders = remainders;
    }
}
