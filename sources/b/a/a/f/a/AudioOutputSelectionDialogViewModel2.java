package b.a.a.f.a;

import b.a.d.AppViewModel;
import b.d.b.a.outline;
import com.discord.rtcconnection.audio.DiscordAudioManager;
import com.discord.stores.StoreAudioManagerV2;
import com.discord.stores.StoreStream;
import com.discord.utilities.error.Error;
import com.discord.utilities.rx.ObservableExtensionsKt;
import d0.z.d.Intrinsics3;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;
import rx.Subscription;

/* JADX INFO: renamed from: b.a.a.f.a.d, reason: use source file name */
/* JADX INFO: compiled from: AudioOutputSelectionDialogViewModel.kt */
/* JADX INFO: loaded from: classes.dex */
public final class AudioOutputSelectionDialogViewModel2 extends AppViewModel<a> {
    public final StoreAudioManagerV2 j;

    /* JADX INFO: renamed from: b.a.a.f.a.d$a */
    /* JADX INFO: compiled from: AudioOutputSelectionDialogViewModel.kt */
    public static abstract class a {

        /* JADX INFO: renamed from: b.a.a.f.a.d$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: AudioOutputSelectionDialogViewModel.kt */
        public static final class C0012a extends a {
            public final DiscordAudioManager.DeviceTypes a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final boolean f48b;
            public final String c;
            public final boolean d;
            public final boolean e;
            public final boolean f;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C0012a(DiscordAudioManager.DeviceTypes deviceTypes, boolean z2, String str, boolean z3, boolean z4, boolean z5) {
                super(null);
                Intrinsics3.checkNotNullParameter(deviceTypes, "selectedAudioOutput");
                this.a = deviceTypes;
                this.f48b = z2;
                this.c = str;
                this.d = z3;
                this.e = z4;
                this.f = z5;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof C0012a)) {
                    return false;
                }
                C0012a c0012a = (C0012a) obj;
                return Intrinsics3.areEqual(this.a, c0012a.a) && this.f48b == c0012a.f48b && Intrinsics3.areEqual(this.c, c0012a.c) && this.d == c0012a.d && this.e == c0012a.e && this.f == c0012a.f;
            }

            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Type inference failed for: r0v10, types: [int] */
            /* JADX WARN: Type inference failed for: r0v12, types: [int] */
            /* JADX WARN: Type inference failed for: r0v4, types: [int] */
            /* JADX WARN: Type inference failed for: r0v8, types: [int] */
            /* JADX WARN: Type inference failed for: r1v10 */
            /* JADX WARN: Type inference failed for: r1v11 */
            /* JADX WARN: Type inference failed for: r1v3, types: [int] */
            /* JADX WARN: Type inference failed for: r1v5, types: [int] */
            /* JADX WARN: Type inference failed for: r1v7 */
            /* JADX WARN: Type inference failed for: r1v8 */
            /* JADX WARN: Type inference failed for: r2v1, types: [int] */
            /* JADX WARN: Type inference failed for: r2v3 */
            /* JADX WARN: Type inference failed for: r2v4 */
            /* JADX WARN: Type inference failed for: r3v0 */
            /* JADX WARN: Type inference failed for: r3v1, types: [int] */
            /* JADX WARN: Type inference failed for: r3v2 */
            public int hashCode() {
                DiscordAudioManager.DeviceTypes deviceTypes = this.a;
                int iHashCode = (deviceTypes != null ? deviceTypes.hashCode() : 0) * 31;
                boolean z2 = this.f48b;
                ?? r2 = z2;
                if (z2) {
                    r2 = 1;
                }
                int i = (iHashCode + r2) * 31;
                String str = this.c;
                int iHashCode2 = (i + (str != null ? str.hashCode() : 0)) * 31;
                boolean z3 = this.d;
                ?? r1 = z3;
                if (z3) {
                    r1 = 1;
                }
                int i2 = (iHashCode2 + r1) * 31;
                boolean z4 = this.e;
                ?? r3 = z4;
                if (z4) {
                    r3 = 1;
                }
                int i3 = (i2 + r3) * 31;
                boolean z5 = this.f;
                return i3 + (z5 ? 1 : z5);
            }

            public String toString() {
                StringBuilder sbU = outline.U("Loaded(selectedAudioOutput=");
                sbU.append(this.a);
                sbU.append(", showBluetoothItem=");
                sbU.append(this.f48b);
                sbU.append(", bluetoothDeviceName=");
                sbU.append(this.c);
                sbU.append(", showSpeakerItem=");
                sbU.append(this.d);
                sbU.append(", showWiredItem=");
                sbU.append(this.e);
                sbU.append(", showEarpieceItem=");
                return outline.O(sbU, this.f, ")");
            }
        }

        /* JADX INFO: renamed from: b.a.a.f.a.d$a$b */
        /* JADX INFO: compiled from: AudioOutputSelectionDialogViewModel.kt */
        public static final class b extends a {
            public static final b a = new b();

            public b() {
                super(null);
            }
        }

        public a() {
        }

        public a(DefaultConstructorMarker defaultConstructorMarker) {
        }
    }

    public AudioOutputSelectionDialogViewModel2() {
        this(null, null, 3);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AudioOutputSelectionDialogViewModel2(StoreAudioManagerV2 storeAudioManagerV2, Observable observable, int i) {
        super(a.b.a);
        StoreAudioManagerV2 audioManagerV2 = (i & 1) != 0 ? StoreStream.INSTANCE.getAudioManagerV2() : null;
        Observable<StoreAudioManagerV2.State> observableObserveAudioManagerState = (i & 2) != 0 ? audioManagerV2.observeAudioManagerState() : null;
        Intrinsics3.checkNotNullParameter(audioManagerV2, "storeAudioManager");
        Intrinsics3.checkNotNullParameter(observableObserveAudioManagerState, "storeStateObservable");
        this.j = audioManagerV2;
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.computationLatest(observableObserveAudioManagerState), this, null, 2, null), (Class<?>) AudioOutputSelectionDialogViewModel2.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.AnonymousClass1.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.AnonymousClass2.INSTANCE : null), new AudioOutputSelectionDialogViewModel(this));
    }
}
