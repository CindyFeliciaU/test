function localDateToDate(localDate) {
    var day = localDate.dayOfMonth;
    var month = localDate.monthValue - 1;
    var year = localDate.year;

    var date = new Date(Date.UTC(year, month, day))

    // Fix en attendant d'avoir l'heure implémentée.
    var now = new Date();

    date.setHours(now.getHours());
    date.setMinutes(now.getMinutes());
    date.setSeconds(now.getSeconds());
    return date;
}