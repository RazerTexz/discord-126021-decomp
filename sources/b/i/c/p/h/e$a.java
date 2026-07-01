package b.i.c.p.h;

import androidx.annotation.NonNull;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

/* JADX INFO: compiled from: JsonDataEncoderBuilder.java */
/* JADX INFO: loaded from: classes3.dex */
public final class e$a implements b.i.c.p.e<Date> {
    public static final DateFormat a;

    static {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", Locale.US);
        a = simpleDateFormat;
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
    }

    public e$a(d dVar) {
    }

    @Override // b.i.c.p.b
    public void a(@NonNull Object obj, @NonNull b.i.c.p.f fVar) throws IOException {
        fVar.d(a.format((Date) obj));
    }
}
