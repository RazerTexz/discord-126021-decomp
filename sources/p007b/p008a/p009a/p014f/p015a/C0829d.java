package p007b.p008a.p009a.p014f.p015a;

import com.discord.rtcconnection.audio.DiscordAudioManager;
import com.discord.stores.StoreAudioManagerV2;
import com.discord.stores.StoreStream;
import com.discord.utilities.error.Error;
import com.discord.utilities.p501rx.ObservableExtensionsKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import p007b.p008a.p018d.AbstractC0859d0;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;
import p658rx.Observable;
import p658rx.Subscription;

/* JADX INFO: renamed from: b.a.a.f.a.d */
/* JADX INFO: compiled from: AudioOutputSelectionDialogViewModel.kt */
/* JADX INFO: loaded from: classes.dex */
public final class C0829d extends AbstractC0859d0<a> {

    /* JADX INFO: renamed from: j */
    public final StoreAudioManagerV2 f360j;

    /* JADX INFO: renamed from: b.a.a.f.a.d$a */
    /* JADX INFO: compiled from: AudioOutputSelectionDialogViewModel.kt */
    public static abstract class a {

        /* JADX INFO: renamed from: b.a.a.f.a.d$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: AudioOutputSelectionDialogViewModel.kt */
        public static final class C13208a extends a {

            /* JADX INFO: renamed from: a */
            public final DiscordAudioManager.DeviceTypes f361a;

            /* JADX INFO: renamed from: b */
            public final boolean f362b;

            /* JADX INFO: renamed from: c */
            public final String f363c;

            /* JADX INFO: renamed from: d */
            public final boolean f364d;

            /* JADX INFO: renamed from: e */
            public final boolean f365e;

            /* JADX INFO: renamed from: f */
            public final boolean f366f;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C13208a(DiscordAudioManager.DeviceTypes deviceTypes, boolean z2, String str, boolean z3, boolean z4, boolean z5) {
                super(null);
                C12238m.checkNotNullParameter(deviceTypes, "selectedAudioOutput");
                this.f361a = deviceTypes;
                this.f362b = z2;
                this.f363c = str;
                this.f364d = z3;
                this.f365e = z4;
                this.f366f = z5;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof C13208a)) {
                    return false;
                }
                C13208a c13208a = (C13208a) obj;
                return C12238m.areEqual(this.f361a, c13208a.f361a) && this.f362b == c13208a.f362b && C12238m.areEqual(this.f363c, c13208a.f363c) && this.f364d == c13208a.f364d && this.f365e == c13208a.f365e && this.f366f == c13208a.f366f;
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
                DiscordAudioManager.DeviceTypes deviceTypes = this.f361a;
                int iHashCode = (deviceTypes != null ? deviceTypes.hashCode() : 0) * 31;
                boolean z2 = this.f362b;
                ?? r2 = z2;
                if (z2) {
                    r2 = 1;
                }
                int i = (iHashCode + r2) * 31;
                String str = this.f363c;
                int iHashCode2 = (i + (str != null ? str.hashCode() : 0)) * 31;
                boolean z3 = this.f364d;
                ?? r1 = z3;
                if (z3) {
                    r1 = 1;
                }
                int i2 = (iHashCode2 + r1) * 31;
                boolean z4 = this.f365e;
                ?? r3 = z4;
                if (z4) {
                    r3 = 1;
                }
                int i3 = (i2 + r3) * 31;
                boolean z5 = this.f366f;
                return i3 + (z5 ? 1 : z5);
            }

            public String toString() {
                StringBuilder sbM833U = C1643a.m833U("Loaded(selectedAudioOutput=");
                sbM833U.append(this.f361a);
                sbM833U.append(", showBluetoothItem=");
                sbM833U.append(this.f362b);
                sbM833U.append(", bluetoothDeviceName=");
                sbM833U.append(this.f363c);
                sbM833U.append(", showSpeakerItem=");
                sbM833U.append(this.f364d);
                sbM833U.append(", showWiredItem=");
                sbM833U.append(this.f365e);
                sbM833U.append(", showEarpieceItem=");
                return C1643a.m827O(sbM833U, this.f366f, ")");
            }
        }

        /* JADX INFO: renamed from: b.a.a.f.a.d$a$b */
        /* JADX INFO: compiled from: AudioOutputSelectionDialogViewModel.kt */
        public static final class b extends a {

            /* JADX INFO: renamed from: a */
            public static final b f367a = new b();

            public b() {
                super(null);
            }
        }

        public a() {
        }

        public a(DefaultConstructorMarker defaultConstructorMarker) {
        }
    }

    public C0829d() {
        this(null, null, 3);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0829d(StoreAudioManagerV2 storeAudioManagerV2, Observable observable, int i) {
        super(a.b.f367a);
        StoreAudioManagerV2 audioManagerV2 = (i & 1) != 0 ? StoreStream.INSTANCE.getAudioManagerV2() : null;
        Observable<StoreAudioManagerV2.State> observableObserveAudioManagerState = (i & 2) != 0 ? audioManagerV2.observeAudioManagerState() : null;
        C12238m.checkNotNullParameter(audioManagerV2, "storeAudioManager");
        C12238m.checkNotNullParameter(observableObserveAudioManagerState, "storeStateObservable");
        this.f360j = audioManagerV2;
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.computationLatest(observableObserveAudioManagerState), this, null, 2, null), (Class<?>) C0829d.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.C68791.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.C68802.INSTANCE : null), new C0828c(this));
    }
}
