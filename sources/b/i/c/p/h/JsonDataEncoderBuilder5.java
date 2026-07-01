package b.i.c.p.h;

import androidx.annotation.NonNull;
import b.d.b.a.outline;
import b.i.c.p.ObjectEncoder;
import b.i.c.p.ObjectEncoderContext;
import b.i.c.p.ValueEncoder;
import b.i.c.p.ValueEncoderContext;
import b.i.c.p.g.EncoderConfig;
import b.i.c.p.h.JsonDataEncoderBuilder5;
import com.google.firebase.encoders.EncodingException;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;

/* JADX INFO: renamed from: b.i.c.p.h.e, reason: use source file name */
/* JADX INFO: compiled from: JsonDataEncoderBuilder.java */
/* JADX INFO: loaded from: classes3.dex */
public final class JsonDataEncoderBuilder5 implements EncoderConfig<JsonDataEncoderBuilder5> {
    public static final a a = new a(null);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map<Class<?>, ObjectEncoder<?>> f1761b;
    public final Map<Class<?>, ValueEncoder<?>> c;
    public ObjectEncoder<Object> d;
    public boolean e;

    /* JADX INFO: renamed from: b.i.c.p.h.e$a */
    /* JADX INFO: compiled from: JsonDataEncoderBuilder.java */
    public static final class a implements ValueEncoder<Date> {
        public static final DateFormat a;

        static {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", Locale.US);
            a = simpleDateFormat;
            simpleDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
        }

        public a(JsonDataEncoderBuilder4 jsonDataEncoderBuilder4) {
        }

        @Override // b.i.c.p.Encoder
        public void a(@NonNull Object obj, @NonNull ValueEncoderContext valueEncoderContext) throws IOException {
            valueEncoderContext.d(a.format((Date) obj));
        }
    }

    public JsonDataEncoderBuilder5() {
        HashMap map = new HashMap();
        this.f1761b = map;
        HashMap map2 = new HashMap();
        this.c = map2;
        this.d = new ObjectEncoder() { // from class: b.i.c.p.h.a
            @Override // b.i.c.p.Encoder
            public void a(Object obj, ObjectEncoderContext objectEncoderContext) {
                JsonDataEncoderBuilder5.a aVar = JsonDataEncoderBuilder5.a;
                StringBuilder sbU = outline.U("Couldn't find encoder for type ");
                sbU.append(obj.getClass().getCanonicalName());
                throw new EncodingException(sbU.toString());
            }
        };
        this.e = false;
        map2.put(String.class, new ValueEncoder() { // from class: b.i.c.p.h.b
            @Override // b.i.c.p.Encoder
            public void a(Object obj, ValueEncoderContext valueEncoderContext) throws IOException {
                JsonDataEncoderBuilder5.a aVar = JsonDataEncoderBuilder5.a;
                valueEncoderContext.d((String) obj);
            }
        });
        map.remove(String.class);
        map2.put(Boolean.class, new ValueEncoder() { // from class: b.i.c.p.h.c
            @Override // b.i.c.p.Encoder
            public void a(Object obj, ValueEncoderContext valueEncoderContext) throws IOException {
                JsonDataEncoderBuilder5.a aVar = JsonDataEncoderBuilder5.a;
                valueEncoderContext.e(((Boolean) obj).booleanValue());
            }
        });
        map.remove(Boolean.class);
        map2.put(Date.class, a);
        map.remove(Date.class);
    }
}
