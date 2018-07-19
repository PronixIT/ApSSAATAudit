package com.pronix.android.apssaataudit.models;

/**
 * Created by NAVEEN KS on 12/20/2017.
 */

public class Worker {
    private String sno, district_code, mandal_code, panchayat_code, village_code, habitation_code, ssaat_code,
            household_code, worker_code, surname, name, account_no, work_code, work_name, work_location,
            work_progress_code, from_date, to_date, days_worked, amount_paid, payment_date, audit_payslip_date,
            muster_id;
    String actualworkeddays, actualamtpaid, differenceinamount, isjobcardavail, ispassbookavail,ispayslipissued,
            resppersonname, resppesonjobdesg, category1, category2, category3,comments, serverFlag;



    public Worker(String sno, String district_code, String mandal_code, String panchayat_code, String village_code, String habitation_code, String ssaat_code,
                  String household_code, String worker_code, String surname, String name, String account_no, String work_code, String work_name,
                  String work_location, String work_progress_code, String from_date, String to_date, String days_worked,
                  String amount_paid, String payment_date, String audit_payslip_date, String muster_id,
                  String actualworkeddays, String actualamtpaid, String differenceinamount, String isjobcardavail,
                  String ispassbookavail, String ispayslipissued, String resppersonname, String resppesonjobdesg, String category1,
                  String category2, String category3, String comments, String serverFlag){
        this.sno = sno;
        this.district_code = district_code;
        this.mandal_code = mandal_code;
        this.panchayat_code = panchayat_code;
        this.village_code = village_code;
        this.habitation_code = habitation_code;
        this.ssaat_code = ssaat_code;
        this.household_code = household_code;
        this.worker_code = worker_code;
        this.surname = surname;
        this.name = name;
        this.account_no = account_no;
        this.work_code = work_code;
        this.work_name = work_name;
        this.work_location = work_location;
        this.work_progress_code = work_progress_code;
        this.from_date = from_date;
        this.to_date = to_date;
        this.days_worked = days_worked;
        this.amount_paid = amount_paid;
        this.payment_date = payment_date;
        this.audit_payslip_date = audit_payslip_date;
        this.muster_id = muster_id;
        this.actualworkeddays = actualworkeddays;
        this.actualamtpaid = actualamtpaid;
        this.differenceinamount = differenceinamount;
        this.isjobcardavail= isjobcardavail;
        this.ispassbookavail= ispassbookavail;
        this.ispayslipissued = ispayslipissued;
        this.resppersonname = resppersonname;
        this.resppesonjobdesg = resppesonjobdesg;
        this.category1 = category1;
        this.category2 = category2;
        this.category3 = category3;
        this.comments = comments;
        this.serverFlag = serverFlag;
    }

    public String getSno() {
        return sno;
    }

    public void setSno(String sno) {
        this.sno = sno;
    }

    public String getDistrict_code() {
        return district_code;
    }

    public void setDistrict_code(String district_code) {
        this.district_code = district_code;
    }

    public String getMandal_code() {
        return mandal_code;
    }

    public void setMandal_code(String mandal_code) {
        this.mandal_code = mandal_code;
    }

    public String getPanchayat_code() {
        return panchayat_code;
    }

    public void setPanchayat_code(String panchayat_code) {
        this.panchayat_code = panchayat_code;
    }

    public String getVillage_code() {
        return village_code;
    }

    public void setVillage_code(String village_code) {
        this.village_code = village_code;
    }

    public String getHabitation_code() {
        return habitation_code;
    }

    public void setHabitation_code(String habitation_code) {
        this.habitation_code = habitation_code;
    }

    public String getSsaat_code() {
        return ssaat_code;
    }

    public void setSsaat_code(String ssaat_code) {
        this.ssaat_code = ssaat_code;
    }

    public String getHousehold_code() {
        return household_code;
    }

    public void setHousehold_code(String household_code) {
        this.household_code = household_code;
    }

    public String getWorker_code() {
        return worker_code;
    }

    public void setWorker_code(String worker_code) {
        this.worker_code = worker_code;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAccount_no() {
        return account_no;
    }

    public void setAccount_no(String account_no) {
        this.account_no = account_no;
    }

    public String getWork_code() {
        return work_code;
    }

    public void setWork_code(String work_code) {
        this.work_code = work_code;
    }

    public String getWork_name() {
        return work_name;
    }

    public void setWork_name(String work_name) {
        this.work_name = work_name;
    }

    public String getWork_location() {
        return work_location;
    }

    public void setWork_location(String work_location) {
        this.work_location = work_location;
    }

    public String getWork_progress_code() {
        return work_progress_code;
    }

    public void setWork_progress_code(String work_progress_code) {
        this.work_progress_code = work_progress_code;
    }

    public String getFrom_date() {
        return from_date;
    }

    public void setFrom_date(String from_date) {
        this.from_date = from_date;
    }

    public String getTo_date() {
        return to_date;
    }

    public void setTo_date(String to_date) {
        this.to_date = to_date;
    }

    public String getDays_worked() {
        return days_worked;
    }

    public void setDays_worked(String days_worked) {
        this.days_worked = days_worked;
    }

    public String getAmount_paid() {
        return amount_paid;
    }

    public void setAmount_paid(String amount_paid) {
        this.amount_paid = amount_paid;
    }

    public String getPayment_date() {
        return payment_date;
    }

    public void setPayment_date(String payment_date) {
        this.payment_date = payment_date;
    }

    public String getAudit_payslip_date() {
        return audit_payslip_date;
    }

    public void setAudit_payslip_date(String audit_payslip_date) {
        this.audit_payslip_date = audit_payslip_date;
    }

    public String getMuster_id() {
        return muster_id;
    }

    public void setMuster_id(String muster_id) {
        this.muster_id = muster_id;
    }
    public String getActualworkeddays() {
        return actualworkeddays;
    }

    public void setActualworkeddays(String actualworkeddays) {
        this.actualworkeddays = actualworkeddays;
    }

    public String getActualamtpaid() {
        return actualamtpaid;
    }

    public void setActualamtpaid(String actualamtpaid) {
        this.actualamtpaid = actualamtpaid;
    }

    public String getDifferenceinamount() {
        return differenceinamount;
    }

    public void setDifferenceinamount(String differenceinamount) {
        this.differenceinamount = differenceinamount;
    }

    public String getIsjobcardavail() {
        return isjobcardavail;
    }

    public void setIsjobcardavail(String isjobcardavail) {
        this.isjobcardavail = isjobcardavail;
    }

    public String getIspassbookavail() {
        return ispassbookavail;
    }

    public void setIspassbookavail(String ispassbookavail) {
        this.ispassbookavail = ispassbookavail;
    }

    public String getIspayslipissued() {
        return ispayslipissued;
    }

    public void setIspayslipissued(String ispayslipissued) {
        this.ispayslipissued = ispayslipissued;
    }

    public String getResppersonname() {
        return resppersonname;
    }

    public void setResppersonname(String resppersonname) {
        this.resppersonname = resppersonname;
    }

    public String getResppesonjobdesg() {
        return resppesonjobdesg;
    }

    public void setResppesonjobdesg(String resppesonjobdesg) {
        this.resppesonjobdesg = resppesonjobdesg;
    }

    public String getCategory1() {
        return category1;
    }

    public void setCategory1(String category1) {
        this.category1 = category1;
    }

    public String getCategory2() {
        return category2;
    }

    public void setCategory2(String category2) {
        this.category2 = category2;
    }

    public String getCategory3() {
        return category3;
    }

    public void setCategory3(String category3) {
        this.category3 = category3;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public String getServerFlag() {
        return serverFlag;
    }

    public void setServerFlag(String serverFlag) {
        this.serverFlag = serverFlag;
    }
}
