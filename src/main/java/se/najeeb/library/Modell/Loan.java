package se.najeeb.library.Modell;

import java.time.LocalDate;

public class Loan {
    private int loanId;
    private int userId;
    private int bookId;
    private LocalDate startDate;
    private LocalDate endDate;

    public Loan(int loanId, int userId, int bookId, LocalDate startDate, LocalDate endDate) {
        this.loanId = loanId;
        this.userId = userId;
        this.bookId = bookId;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public Loan(int userId, int bookId, LocalDate startDate, LocalDate endDate) {
        this.userId = userId;
        this.bookId = bookId;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public int getLoanId() {
        return loanId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    @Override
    public String toString() {
        return "Loan{" +
                "loanId=" + loanId +
                ", userId=" + userId +
                ", bookId=" + bookId +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                '}';
    }
}
