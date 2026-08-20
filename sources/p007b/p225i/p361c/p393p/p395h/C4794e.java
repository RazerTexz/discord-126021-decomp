package p007b.p225i.p361c.p393p.p395h;

import androidx.annotation.NonNull;
import com.google.firebase.encoders.EncodingException;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import p007b.p100d.p104b.p105a.C1643a;
import p007b.p225i.p361c.p393p.InterfaceC4784c;
import p007b.p225i.p361c.p393p.InterfaceC4785d;
import p007b.p225i.p361c.p393p.InterfaceC4786e;
import p007b.p225i.p361c.p393p.InterfaceC4787f;
import p007b.p225i.p361c.p393p.p394g.InterfaceC4789b;

/* JADX INFO: renamed from: b.i.c.p.h.e */
/* JADX INFO: compiled from: JsonDataEncoderBuilder.java */
/* JADX INFO: loaded from: classes3.dex */
public final class C4794e implements InterfaceC4789b<C4794e> {

    /* JADX INFO: renamed from: a */
    public static final a f12821a = new a(null);

    /* JADX INFO: renamed from: b */
    public final Map<Class<?>, InterfaceC4784c<?>> f12822b;

    /* JADX INFO: renamed from: c */
    public final Map<Class<?>, InterfaceC4786e<?>> f12823c;

    /* JADX INFO: renamed from: d */
    public InterfaceC4784c<Object> f12824d;

    /* JADX INFO: renamed from: e */
    public boolean f12825e;

    /* JADX INFO: renamed from: b.i.c.p.h.e$a */
    /* JADX INFO: compiled from: JsonDataEncoderBuilder.java */
    public static final class a implements InterfaceC4786e<Date> {

        /* JADX INFO: renamed from: a */
        public static final DateFormat f12826a;

        static {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", Locale.US);
            f12826a = simpleDateFormat;
            simpleDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
        }

        public a(C4793d c4793d) {
        }

        @Override // p007b.p225i.p361c.p393p.InterfaceC4783b
        /* JADX INFO: renamed from: a */
        public void mo2312a(@NonNull Object obj, @NonNull InterfaceC4787f interfaceC4787f) throws IOException {
            interfaceC4787f.mo6709d(f12826a.format((Date) obj));
        }
    }

    public C4794e() {
        HashMap map = new HashMap();
        this.f12822b = map;
        HashMap map2 = new HashMap();
        this.f12823c = map2;
        this.f12824d = new InterfaceC4784c() { // from class: b.i.c.p.h.a
            @Override // p007b.p225i.p361c.p393p.InterfaceC4783b
            /* JADX INFO: renamed from: a */
            public void mo2312a(Object obj, InterfaceC4785d interfaceC4785d) {
                C4794e.a aVar = C4794e.f12821a;
                StringBuilder sbM833U = C1643a.m833U("Couldn't find encoder for type ");
                sbM833U.append(obj.getClass().getCanonicalName());
                throw new EncodingException(sbM833U.toString());
            }
        };
        this.f12825e = false;
        map2.put(String.class, new InterfaceC4786e() { // from class: b.i.c.p.h.b
            @Override // p007b.p225i.p361c.p393p.InterfaceC4783b
            /* JADX INFO: renamed from: a */
            public void mo2312a(Object obj, InterfaceC4787f interfaceC4787f) throws IOException {
                C4794e.a aVar = C4794e.f12821a;
                interfaceC4787f.mo6709d((String) obj);
            }
        });
        map.remove(String.class);
        map2.put(Boolean.class, new InterfaceC4786e() { // from class: b.i.c.p.h.c
            @Override // p007b.p225i.p361c.p393p.InterfaceC4783b
            /* JADX INFO: renamed from: a */
            public void mo2312a(Object obj, InterfaceC4787f interfaceC4787f) throws IOException {
                C4794e.a aVar = C4794e.f12821a;
                interfaceC4787f.mo6710e(((Boolean) obj).booleanValue());
            }
        });
        map.remove(Boolean.class);
        map2.put(Date.class, f12821a);
        map.remove(Date.class);
    }
}
