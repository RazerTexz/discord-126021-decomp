package com.esotericsoftware.kryo.serializers;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.Serializer;
import com.esotericsoftware.kryo.io.Input;
import com.esotericsoftware.kryo.io.Output;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.TimeZone;

/* JADX INFO: loaded from: classes.dex */
public class DefaultSerializers$CalendarSerializer extends Serializer<Calendar> {
    private static final long DEFAULT_GREGORIAN_CUTOVER = -12219292800000L;
    public DefaultSerializers$TimeZoneSerializer timeZoneSerializer = new DefaultSerializers$TimeZoneSerializer();

    @Override // com.esotericsoftware.kryo.Serializer
    public /* bridge */ /* synthetic */ Calendar copy(Kryo kryo, Calendar calendar) {
        return copy2(kryo, calendar);
    }

    @Override // com.esotericsoftware.kryo.Serializer
    public /* bridge */ /* synthetic */ Calendar read(Kryo kryo, Input input, Class<Calendar> cls) {
        return read2(kryo, input, cls);
    }

    @Override // com.esotericsoftware.kryo.Serializer
    public /* bridge */ /* synthetic */ void write(Kryo kryo, Output output, Calendar calendar) {
        write2(kryo, output, calendar);
    }

    /* JADX INFO: renamed from: copy, reason: avoid collision after fix types in other method */
    public Calendar copy2(Kryo kryo, Calendar calendar) {
        return (Calendar) calendar.clone();
    }

    @Override // com.esotericsoftware.kryo.Serializer
    /* JADX INFO: renamed from: read, reason: avoid collision after fix types in other method */
    public Calendar read2(Kryo kryo, Input input, Class<Calendar> cls) {
        Calendar calendar = Calendar.getInstance(this.timeZoneSerializer.read2(kryo, input, TimeZone.class));
        calendar.setTimeInMillis(input.readLong(true));
        calendar.setLenient(input.readBoolean());
        calendar.setFirstDayOfWeek(input.readInt(true));
        calendar.setMinimalDaysInFirstWeek(input.readInt(true));
        long j = input.readLong(false);
        if (j != DEFAULT_GREGORIAN_CUTOVER && (calendar instanceof GregorianCalendar)) {
            ((GregorianCalendar) calendar).setGregorianChange(new Date(j));
        }
        return calendar;
    }

    /* JADX INFO: renamed from: write, reason: avoid collision after fix types in other method */
    public void write2(Kryo kryo, Output output, Calendar calendar) {
        this.timeZoneSerializer.write2(kryo, output, calendar.getTimeZone());
        output.writeLong(calendar.getTimeInMillis(), true);
        output.writeBoolean(calendar.isLenient());
        output.writeInt(calendar.getFirstDayOfWeek(), true);
        output.writeInt(calendar.getMinimalDaysInFirstWeek(), true);
        if (calendar instanceof GregorianCalendar) {
            output.writeLong(((GregorianCalendar) calendar).getGregorianChange().getTime(), false);
        } else {
            output.writeLong(DEFAULT_GREGORIAN_CUTOVER, false);
        }
    }
}
