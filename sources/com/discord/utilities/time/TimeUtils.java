package com.discord.utilities.time;

import android.content.Context;
import android.text.format.DateUtils;
import com.adjust.sdk.Constants;
import com.discord.i18n.RenderContext;
import com.discord.utilities.SnowflakeUtils;
import com.discord.utilities.locale.LocaleManager;
import java.text.DateFormat;
import java.text.DateFormatSymbols;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import p007b.p008a.p027k.C1107b;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: TimeUtils.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class TimeUtils {
    private static final String DATE_FORMAT_DISCORD_API = "yyyy-MM-dd'T'HH:mm:ss";
    public static final TimeUtils INSTANCE = new TimeUtils();
    private static final LocaleManager localeManager = new LocaleManager();

    /* JADX INFO: compiled from: TimeUtils.kt */
    public static final class UTCFormat {
        public static final UTCFormat INSTANCE = new UTCFormat();
        public static final String LONG = "yyyy-MM-dd'T'HH:mm:ss";
        public static final String SHORT = "yyyy-MM-dd";

        private UTCFormat() {
        }
    }

    private TimeUtils() {
    }

    public static final long addDaysToDate(String date, int days) {
        Calendar calendar = toCalendar(parseUTCDate(date));
        calendar.add(5, days);
        return calendar.getTimeInMillis();
    }

    public static final String addMonthsAndDaysToDate(String date, int months, int days) {
        Calendar calendar = toCalendar(parseUTCDate(date));
        calendar.add(5, days);
        calendar.add(2, months);
        return toUTCDateTime$default(Long.valueOf(calendar.getTimeInMillis()), null, 2, null);
    }

    public static /* synthetic */ String addMonthsAndDaysToDate$default(String str, int i, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = 0;
        }
        return addMonthsAndDaysToDate(str, i, i2);
    }

    public static final String currentTimeUTCDateString(Clock clock) {
        C12238m.checkNotNullParameter(clock, "clock");
        return toUTCDateTime$default(Long.valueOf(clock.currentTimeMillis()), null, 2, null);
    }

    public static final int getMonthsBetweenDates(Date firstDate, Date secondDate) {
        C12238m.checkNotNullParameter(firstDate, "firstDate");
        C12238m.checkNotNullParameter(secondDate, "secondDate");
        Calendar calendar = Calendar.getInstance();
        if (firstDate.before(secondDate)) {
            C12238m.checkNotNullExpressionValue(calendar, "calendar");
            calendar.setTime(firstDate);
            firstDate = secondDate;
        } else {
            C12238m.checkNotNullExpressionValue(calendar, "calendar");
            calendar.setTime(secondDate);
        }
        int i = 0;
        while (calendar.getTime().before(firstDate)) {
            calendar.add(2, 1);
            i++;
        }
        return i - 1;
    }

    public static final String getReadableTimeString(Context context, String utcDate) {
        C12238m.checkNotNullParameter(context, "context");
        return toReadableTimeString$default(context, parseUTCDate(utcDate), null, 4, null).toString();
    }

    public static final long millisToSnowflake(long millis) {
        return (millis - SnowflakeUtils.DISCORD_EPOCH) << 22;
    }

    public static final long parseSnowflake(Long snowflake) {
        if (snowflake == null) {
            snowflake = 0L;
        }
        return (snowflake.longValue() >> 22) + SnowflakeUtils.DISCORD_EPOCH;
    }

    public static final long parseUTCDate(String dateTime) {
        if (dateTime == null) {
            return 0L;
        }
        try {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss", Locale.ROOT);
            simpleDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
            Date date = simpleDateFormat.parse(dateTime);
            if (date != null) {
                return date.getTime();
            }
            return 0L;
        } catch (ArrayIndexOutOfBoundsException | NumberFormatException | ParseException unused) {
            return 0L;
        }
    }

    public static /* synthetic */ String renderUtcDate$default(TimeUtils timeUtils, String str, Context context, String str2, DateFormat dateFormat, int i, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            str2 = "yyyy-MM-dd'T'HH:mm:ss";
        }
        String str3 = str2;
        if ((i2 & 8) != 0) {
            dateFormat = android.text.format.DateFormat.getMediumDateFormat(context);
            C12238m.checkNotNullExpressionValue(dateFormat, "DateFormat.getMediumDateFormat(context)");
        }
        return timeUtils.renderUtcDate(str, context, str3, dateFormat, (i2 & 16) != 0 ? 0 : i);
    }

    public static /* synthetic */ String renderUtcDateTime$default(TimeUtils timeUtils, String str, Context context, String str2, int i, int i2, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            str2 = "yyyy-MM-dd'T'HH:mm:ss";
        }
        return timeUtils.renderUtcDateTime(str, context, str2, i, i2);
    }

    public static final Calendar toCalendar(long unixTimeMillis) {
        Calendar calendar = Calendar.getInstance(Locale.ROOT);
        C12238m.checkNotNullExpressionValue(calendar, "calendar");
        calendar.setTimeInMillis(unixTimeMillis);
        return calendar;
    }

    public static /* synthetic */ CharSequence toFriendlyString$default(TimeUtils timeUtils, long j, long j2, String str, String str2, int i, Object obj) {
        if ((i & 2) != 0) {
            j2 = ClockFactory.get().currentTimeMillis();
        }
        return timeUtils.toFriendlyString(j, j2, (i & 4) != 0 ? null : str, (i & 8) != 0 ? null : str2);
    }

    public static /* synthetic */ CharSequence toFriendlyStringSimple$default(TimeUtils timeUtils, long j, String str, String str2, int i, Object obj) {
        if ((i & 2) != 0) {
            str = null;
        }
        if ((i & 4) != 0) {
            str2 = null;
        }
        return timeUtils.toFriendlyStringSimple(j, str, str2);
    }

    public static final CharSequence toReadableTimeString(Context context, long timestampMs, Clock clock) {
        C12238m.checkNotNullParameter(context, "context");
        C12238m.checkNotNullParameter(clock, "clock");
        LocaleManager localeManager2 = localeManager;
        if (C12238m.areEqual(localeManager2.getPrimaryLocale(context).getLanguage(), "en")) {
            return INSTANCE.toReadableTimeStringEN(localeManager2.getPrimaryLocale(context), timestampMs, clock);
        }
        CharSequence relativeDateTimeString = DateUtils.getRelativeDateTimeString(context, timestampMs, 86400000L, 604800000L, 131072);
        C12238m.checkNotNullExpressionValue(relativeDateTimeString, "DateUtils.getRelativeDat…RMAT_NUMERIC_DATE\n      )");
        return relativeDateTimeString;
    }

    public static /* synthetic */ CharSequence toReadableTimeString$default(Context context, long j, Clock clock, int i, Object obj) {
        if ((i & 4) != 0) {
            clock = ClockFactory.get();
        }
        return toReadableTimeString(context, j, clock);
    }

    public static /* synthetic */ String toReadableTimeStringEN$default(TimeUtils timeUtils, Locale locale, long j, Clock clock, int i, Object obj) {
        if ((i & 4) != 0) {
            clock = ClockFactory.get();
        }
        return timeUtils.toReadableTimeStringEN(locale, j, clock);
    }

    public static final String toUTCDateTime(Long unixTimeMillis, String format) {
        C12238m.checkNotNullParameter(format, "format");
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format, Locale.ROOT);
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
        if (unixTimeMillis == null) {
            return null;
        }
        return simpleDateFormat.format(new Date(unixTimeMillis.longValue()));
    }

    public static /* synthetic */ String toUTCDateTime$default(Long l, String str, int i, Object obj) {
        if ((i & 2) != 0) {
            str = "yyyy-MM-dd'T'HH:mm:ss";
        }
        return toUTCDateTime(l, str);
    }

    public final int getDaysFromMillis(long millis) {
        long j = 86400000;
        if (millis < j) {
            return 0;
        }
        return (int) (millis / j);
    }

    public final int getHoursFromMillis(long millis) {
        long j = Constants.ONE_HOUR;
        if (millis < j) {
            return 0;
        }
        return (int) (millis / j);
    }

    public final String getLocalizedMonthName(int monthInt, Context context) {
        C12238m.checkNotNullParameter(context, "context");
        String str = new DateFormatSymbols(localeManager.getPrimaryLocale(context)).getMonths()[monthInt - 1];
        C12238m.checkNotNullExpressionValue(str, "DateFormatSymbols(locale…xt)).months[monthInt - 1]");
        return str;
    }

    public final int getMinutesFromMillis(long millis) {
        long j = 60000;
        if (millis < j) {
            return 0;
        }
        return (int) (millis / j);
    }

    public final int getSecondsFromMillis(long millis) {
        long j = 1000;
        if (millis < j) {
            return 0;
        }
        return (int) (millis / j);
    }

    public final String renderUtcDate(String utcDate, Context context, String inputFormat, DateFormat outputFormat, int offsetDays) {
        C12238m.checkNotNullParameter(utcDate, "utcDate");
        C12238m.checkNotNullParameter(context, "context");
        C12238m.checkNotNullParameter(inputFormat, "inputFormat");
        C12238m.checkNotNullParameter(outputFormat, "outputFormat");
        return renderUtcDate(utcDate, localeManager.getPrimaryLocale(context), inputFormat, outputFormat, offsetDays);
    }

    public final String renderUtcDateTime(String utcDateTime, Context context, String inputFormat, int outputDateFormat, int outputTimeFormat) {
        C12238m.checkNotNullParameter(utcDateTime, "utcDateTime");
        C12238m.checkNotNullParameter(context, "context");
        C12238m.checkNotNullParameter(inputFormat, "inputFormat");
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(inputFormat, localeManager.getPrimaryLocale(context));
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
        Date date = simpleDateFormat.parse(utcDateTime);
        if (date == null) {
            date = new Date();
        }
        String str = DateFormat.getDateTimeInstance(outputDateFormat, outputTimeFormat).format(date);
        C12238m.checkNotNullExpressionValue(str, "outputDateFormatInstance.format(date)");
        return str;
    }

    public final CharSequence toFriendlyString(long startTimeMs, long targetTimestampMs, String formatString, String argName) {
        long j = targetTimestampMs - startTimeMs;
        if (TimeUnit.MILLISECONDS.toDays(j) == 0) {
            return toFriendlyStringSimple(j, formatString, argName);
        }
        CharSequence relativeTimeSpanString = DateUtils.getRelativeTimeSpanString(startTimeMs, targetTimestampMs, 86400000L, 131072);
        C12238m.checkNotNullExpressionValue(relativeTimeSpanString, "DateUtils.getRelativeTim…AT_NUMERIC_DATE\n        )");
        return relativeTimeSpanString;
    }

    public final CharSequence toFriendlyStringSimple(long deltaTimeMs, String formatString, String argName) {
        String elapsedTime = DateUtils.formatElapsedTime(TimeUnit.MILLISECONDS.toSeconds(Math.max(0L, deltaTimeMs)));
        if (formatString == null || argName == null) {
            C12238m.checkNotNullExpressionValue(elapsedTime, "elapsedTime");
            return elapsedTime;
        }
        return C1107b.m215g(formatString, new Object[0], new C69781(elapsedTime, argName));
    }

    public final String toReadableTimeStringEN(Locale locale, long unixTimeMillis, Clock clock) {
        C12238m.checkNotNullParameter(locale, "locale");
        C12238m.checkNotNullParameter(clock, "clock");
        if (!C12238m.areEqual(locale.getLanguage(), "en")) {
            return "";
        }
        DateFormat timeInstance = DateFormat.getTimeInstance(3, locale);
        DateFormat dateTimeInstance = DateFormat.getDateTimeInstance(2, 3, locale);
        Calendar calendar = toCalendar(clock.currentTimeMillis());
        calendar.set(11, 0);
        calendar.set(12, 0);
        calendar.set(13, 0);
        calendar.set(14, 0);
        calendar.add(5, 1);
        if (unixTimeMillis > calendar.getTimeInMillis()) {
            String str = dateTimeInstance.format(Long.valueOf(unixTimeMillis));
            C12238m.checkNotNullExpressionValue(str, "formatterDateTime.format(unixTimeMillis)");
            return str;
        }
        calendar.add(5, -1);
        if (unixTimeMillis > calendar.getTimeInMillis()) {
            StringBuilder sbM833U = C1643a.m833U("Today at ");
            sbM833U.append(timeInstance.format(Long.valueOf(unixTimeMillis)));
            return sbM833U.toString();
        }
        calendar.add(5, -1);
        if (unixTimeMillis > calendar.getTimeInMillis()) {
            StringBuilder sbM833U2 = C1643a.m833U("Yesterday at ");
            sbM833U2.append(timeInstance.format(Long.valueOf(unixTimeMillis)));
            return sbM833U2.toString();
        }
        String str2 = dateTimeInstance.format(Long.valueOf(unixTimeMillis));
        C12238m.checkNotNullExpressionValue(str2, "formatterDateTime.format(unixTimeMillis)");
        return str2;
    }

    /* JADX INFO: renamed from: com.discord.utilities.time.TimeUtils$toFriendlyStringSimple$1 */
    /* JADX INFO: compiled from: TimeUtils.kt */
    public static final class C69781 extends AbstractC12240o implements Function1<RenderContext, Unit> {
        public final /* synthetic */ String $argName;
        public final /* synthetic */ String $elapsedTime;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C69781(String str, String str2) {
            super(1);
            this.$elapsedTime = str;
            this.$argName = str2;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(RenderContext renderContext) {
            C12238m.checkNotNullParameter(renderContext, "$receiver");
            Map<String, String> map = renderContext.args;
            String str = this.$argName;
            String str2 = this.$elapsedTime;
            C12238m.checkNotNullExpressionValue(str2, "elapsedTime");
            map.put(str, str2);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(RenderContext renderContext) {
            invoke2(renderContext);
            return Unit.f27425a;
        }
    }

    private final String renderUtcDate(String utcDate, Locale locale, String inputFormat, DateFormat outputFormat, int offsetDays) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(inputFormat, locale);
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
        Date date = simpleDateFormat.parse(utcDate);
        Calendar calendar = Calendar.getInstance(locale);
        C12238m.checkNotNullExpressionValue(calendar, "calendar");
        if (date == null) {
            date = new Date();
        }
        calendar.setTime(date);
        calendar.add(5, offsetDays);
        String str = outputFormat.format(calendar.getTime());
        C12238m.checkNotNullExpressionValue(str, "outputFormat.format(offsetDate)");
        return str;
    }

    public static /* synthetic */ String renderUtcDate$default(TimeUtils timeUtils, String str, Locale locale, String str2, DateFormat dateFormat, int i, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            str2 = "yyyy-MM-dd'T'HH:mm:ss";
        }
        return timeUtils.renderUtcDate(str, locale, str2, dateFormat, (i2 & 16) != 0 ? 0 : i);
    }

    public static /* synthetic */ String renderUtcDate$default(TimeUtils timeUtils, long j, Context context, int i, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            i = 2;
        }
        return timeUtils.renderUtcDate(j, context, i);
    }

    public final String renderUtcDate(long unixTimeMillis, Context context, int outputFormat) {
        C12238m.checkNotNullParameter(context, "context");
        String str = DateFormat.getDateInstance(outputFormat, localeManager.getPrimaryLocale(context)).format(Long.valueOf(unixTimeMillis));
        C12238m.checkNotNullExpressionValue(str, "formatter.format(unixTimeMillis)");
        return str;
    }
}
