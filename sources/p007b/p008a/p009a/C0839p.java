package p007b.p008a.p009a;

import com.discord.stores.StoreNotices;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreUserSettings;
import java.util.Objects;
import kotlin.jvm.internal.DefaultConstructorMarker;
import p007b.p008a.p018d.AbstractC0859d0;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: b.a.a.p */
/* JADX INFO: compiled from: WidgetAccessibilityDetectionDialogViewModel.kt */
/* JADX INFO: loaded from: classes.dex */
public final class C0839p extends AbstractC0859d0<a> {

    /* JADX INFO: renamed from: j */
    public final StoreUserSettings f419j;

    /* JADX INFO: renamed from: k */
    public final StoreNotices f420k;

    /* JADX INFO: renamed from: b.a.a.p$a */
    /* JADX INFO: compiled from: WidgetAccessibilityDetectionDialogViewModel.kt */
    public static abstract class a {

        /* JADX INFO: renamed from: b.a.a.p$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: WidgetAccessibilityDetectionDialogViewModel.kt */
        public static final class C13209a extends a {

            /* JADX INFO: renamed from: a */
            public static final C13209a f421a = new C13209a();

            public C13209a() {
                super(null);
            }
        }

        public a(DefaultConstructorMarker defaultConstructorMarker) {
        }
    }

    public C0839p() {
        this(null, null, 3);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0839p(StoreUserSettings storeUserSettings, StoreNotices storeNotices, int i) {
        super(a.C13209a.f421a);
        StoreUserSettings userSettings = (i & 1) != 0 ? StoreStream.INSTANCE.getUserSettings() : null;
        StoreNotices notices = (i & 2) != 0 ? StoreStream.INSTANCE.getNotices() : null;
        C12238m.checkNotNullParameter(userSettings, "storeUserSettings");
        C12238m.checkNotNullParameter(notices, "storeNotices");
        this.f419j = userSettings;
        this.f420k = notices;
    }

    @Override // p007b.p008a.p018d.AbstractC0859d0, androidx.view.ViewModel
    public void onCleared() {
        StoreNotices storeNotices = this.f420k;
        Objects.requireNonNull(C0831h.INSTANCE);
        StoreNotices.markSeen$default(storeNotices, "ALLOW_ACCESSIBILITY_DETECTION_DIALOG", 0L, 2, null);
    }
}
