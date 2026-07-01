package b.a.a;

import b.a.d.AppViewModel;
import com.discord.stores.StoreNotices;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreUserSettings;
import d0.z.d.Intrinsics3;
import java.util.Objects;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: renamed from: b.a.a.p, reason: use source file name */
/* JADX INFO: compiled from: WidgetAccessibilityDetectionDialogViewModel.kt */
/* JADX INFO: loaded from: classes.dex */
public final class WidgetAccessibilityDetectionDialogViewModel extends AppViewModel<a> {
    public final StoreUserSettings j;
    public final StoreNotices k;

    /* JADX INFO: renamed from: b.a.a.p$a */
    /* JADX INFO: compiled from: WidgetAccessibilityDetectionDialogViewModel.kt */
    public static abstract class a {

        /* JADX INFO: renamed from: b.a.a.p$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: WidgetAccessibilityDetectionDialogViewModel.kt */
        public static final class C0013a extends a {
            public static final C0013a a = new C0013a();

            public C0013a() {
                super(null);
            }
        }

        public a(DefaultConstructorMarker defaultConstructorMarker) {
        }
    }

    public WidgetAccessibilityDetectionDialogViewModel() {
        this(null, null, 3);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetAccessibilityDetectionDialogViewModel(StoreUserSettings storeUserSettings, StoreNotices storeNotices, int i) {
        super(a.C0013a.a);
        StoreUserSettings userSettings = (i & 1) != 0 ? StoreStream.INSTANCE.getUserSettings() : null;
        StoreNotices notices = (i & 2) != 0 ? StoreStream.INSTANCE.getNotices() : null;
        Intrinsics3.checkNotNullParameter(userSettings, "storeUserSettings");
        Intrinsics3.checkNotNullParameter(notices, "storeNotices");
        this.j = userSettings;
        this.k = notices;
    }

    @Override // b.a.d.AppViewModel, androidx.view.ViewModel
    public void onCleared() {
        StoreNotices storeNotices = this.k;
        Objects.requireNonNull(WidgetAccessibilityDetectionDialog.INSTANCE);
        StoreNotices.markSeen$default(storeNotices, "ALLOW_ACCESSIBILITY_DETECTION_DIALOG", 0L, 2, null);
    }
}
