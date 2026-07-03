package p007b.p452o.p453a.p467r;

import android.annotation.SuppressLint;
import android.media.CamcorderProfile;
import androidx.annotation.NonNull;
import com.discord.utilities.voice.ScreenShareManager;
import com.discord.widgets.settings.profile.WidgetEditUserOrGuildMemberProfile;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import org.objectweb.asm.Opcodes;
import p007b.p452o.p453a.C5103b;
import p007b.p452o.p453a.p473x.C5236b;

/* JADX INFO: renamed from: b.o.a.r.a */
/* JADX INFO: compiled from: CamcorderProfiles.java */
/* JADX INFO: loaded from: classes3.dex */
public class C5200a {

    /* JADX INFO: renamed from: a */
    public static final C5103b f14100a = new C5103b(C5200a.class.getSimpleName());

    /* JADX INFO: renamed from: b */
    @SuppressLint({"UseSparseArrays"})
    public static Map<C5236b, Integer> f14101b;

    /* JADX INFO: renamed from: b.o.a.r.a$a */
    /* JADX INFO: compiled from: CamcorderProfiles.java */
    public class a implements Comparator<C5236b> {

        /* JADX INFO: renamed from: j */
        public final /* synthetic */ long f14102j;

        public a(long j) {
            this.f14102j = j;
        }

        @Override // java.util.Comparator
        public int compare(C5236b c5236b, C5236b c5236b2) {
            C5236b c5236b3 = c5236b;
            C5236b c5236b4 = c5236b2;
            long jAbs = Math.abs(((long) (c5236b3.f14251j * c5236b3.f14252k)) - this.f14102j);
            long jAbs2 = Math.abs(((long) (c5236b4.f14251j * c5236b4.f14252k)) - this.f14102j);
            if (jAbs < jAbs2) {
                return -1;
            }
            return jAbs == jAbs2 ? 0 : 1;
        }
    }

    static {
        HashMap map = new HashMap();
        f14101b = map;
        map.put(new C5236b(Opcodes.ARETURN, Opcodes.D2F), 2);
        f14101b.put(new C5236b(320, 240), 7);
        f14101b.put(new C5236b(352, ScreenShareManager.THUMBNAIL_HEIGHT_PX), 3);
        f14101b.put(new C5236b(720, 480), 4);
        f14101b.put(new C5236b(1280, 720), 5);
        f14101b.put(new C5236b(1920, WidgetEditUserOrGuildMemberProfile.MAX_BANNER_IMAGE_SIZE), 6);
        f14101b.put(new C5236b(3840, 2160), 8);
    }

    @NonNull
    /* JADX INFO: renamed from: a */
    public static CamcorderProfile m7397a(int i, @NonNull C5236b c5236b) {
        long j = ((long) c5236b.f14251j) * ((long) c5236b.f14252k);
        ArrayList arrayList = new ArrayList(f14101b.keySet());
        Collections.sort(arrayList, new a(j));
        while (arrayList.size() > 0) {
            int iIntValue = f14101b.get((C5236b) arrayList.remove(0)).intValue();
            if (CamcorderProfile.hasProfile(i, iIntValue)) {
                return CamcorderProfile.get(i, iIntValue);
            }
        }
        return CamcorderProfile.get(i, 0);
    }

    @NonNull
    /* JADX INFO: renamed from: b */
    public static CamcorderProfile m7398b(@NonNull String str, @NonNull C5236b c5236b) {
        try {
            return m7397a(Integer.parseInt(str), c5236b);
        } catch (NumberFormatException unused) {
            f14100a.m7159a(2, "NumberFormatException for Camera2 id:", str);
            return CamcorderProfile.get(0);
        }
    }
}
