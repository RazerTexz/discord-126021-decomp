package com.discord.utilities.birthday;

import com.discord.utilities.time.ClockFactory;
import d0.z.d.Intrinsics3;
import java.util.Calendar;

/* JADX INFO: compiled from: BirthdayHelper.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class BirthdayHelper {
    public static final String DATE_OF_BIRTH_KEY = "date_of_birth";
    public static final BirthdayHelper INSTANCE = new BirthdayHelper();
    public static final int USER_DEFAULT_AGE = 10;
    public static final int USER_MIN_AGE_NSFW = 18;

    private BirthdayHelper() {
    }

    public final long defaultInputAge() {
        return subtractYearsFromToday(10);
    }

    public final int getAge(long dateOfBirth) {
        long jCurrentTimeMillis = ClockFactory.get().currentTimeMillis();
        Calendar calendar = Calendar.getInstance();
        Calendar calendar2 = Calendar.getInstance();
        Intrinsics3.checkNotNullExpressionValue(calendar, "nowCalendar");
        calendar.setTimeInMillis(jCurrentTimeMillis);
        Intrinsics3.checkNotNullExpressionValue(calendar2, "dobCalendar");
        calendar2.setTimeInMillis(dateOfBirth);
        return (calendar2.get(2) > calendar.get(2) || (calendar2.get(2) == calendar.get(2) && calendar2.get(5) > calendar.get(5))) ? (calendar.get(1) - calendar2.get(1)) - 1 : calendar.get(1) - calendar2.get(1);
    }

    public final long getMaxDateOfBirth() {
        return subtractYearsFromToday(3);
    }

    public final long subtractYearsFromToday(int years) {
        long jCurrentTimeMillis = ClockFactory.get().currentTimeMillis();
        Calendar calendar = Calendar.getInstance();
        Intrinsics3.checkNotNullExpressionValue(calendar, "calendar");
        calendar.setTimeInMillis(jCurrentTimeMillis);
        calendar.set(1, calendar.get(1) - years);
        return calendar.getTimeInMillis();
    }
}
