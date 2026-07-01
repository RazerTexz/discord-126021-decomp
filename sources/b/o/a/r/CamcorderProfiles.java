package b.o.a.r;

import android.annotation.SuppressLint;
import android.media.CamcorderProfile;
import androidx.annotation.NonNull;
import b.o.a.CameraLogger;
import b.o.a.x.Size3;
import com.discord.utilities.voice.ScreenShareManager;
import com.discord.widgets.settings.profile.WidgetEditUserOrGuildMemberProfile;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import org.objectweb.asm.Opcodes;

/* JADX INFO: renamed from: b.o.a.r.a, reason: use source file name */
/* JADX INFO: compiled from: CamcorderProfiles.java */
/* JADX INFO: loaded from: classes3.dex */
public class CamcorderProfiles {
    public static final CameraLogger a = new CameraLogger(CamcorderProfiles.class.getSimpleName());

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @SuppressLint({"UseSparseArrays"})
    public static Map<Size3, Integer> f1948b;

    /* JADX INFO: renamed from: b.o.a.r.a$a */
    /* JADX INFO: compiled from: CamcorderProfiles.java */
    public class a implements Comparator<Size3> {
        public final /* synthetic */ long j;

        public a(long j) {
            this.j = j;
        }

        @Override // java.util.Comparator
        public int compare(Size3 size3, Size3 size4) {
            Size3 size5 = size3;
            Size3 size6 = size4;
            long jAbs = Math.abs(((long) (size5.j * size5.k)) - this.j);
            long jAbs2 = Math.abs(((long) (size6.j * size6.k)) - this.j);
            if (jAbs < jAbs2) {
                return -1;
            }
            return jAbs == jAbs2 ? 0 : 1;
        }
    }

    static {
        HashMap map = new HashMap();
        f1948b = map;
        map.put(new Size3(Opcodes.ARETURN, Opcodes.D2F), 2);
        f1948b.put(new Size3(320, 240), 7);
        f1948b.put(new Size3(352, ScreenShareManager.THUMBNAIL_HEIGHT_PX), 3);
        f1948b.put(new Size3(720, 480), 4);
        f1948b.put(new Size3(1280, 720), 5);
        f1948b.put(new Size3(1920, WidgetEditUserOrGuildMemberProfile.MAX_BANNER_IMAGE_SIZE), 6);
        f1948b.put(new Size3(3840, 2160), 8);
    }

    @NonNull
    public static CamcorderProfile a(int i, @NonNull Size3 size3) {
        long j = ((long) size3.j) * ((long) size3.k);
        ArrayList arrayList = new ArrayList(f1948b.keySet());
        Collections.sort(arrayList, new a(j));
        while (arrayList.size() > 0) {
            int iIntValue = f1948b.get((Size3) arrayList.remove(0)).intValue();
            if (CamcorderProfile.hasProfile(i, iIntValue)) {
                return CamcorderProfile.get(i, iIntValue);
            }
        }
        return CamcorderProfile.get(i, 0);
    }

    @NonNull
    public static CamcorderProfile b(@NonNull String str, @NonNull Size3 size3) {
        try {
            return a(Integer.parseInt(str), size3);
        } catch (NumberFormatException unused) {
            a.a(2, "NumberFormatException for Camera2 id:", str);
            return CamcorderProfile.get(0);
        }
    }
}
