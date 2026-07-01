package b.a.a.f.a;

import com.discord.rtcconnection.audio.DiscordAudioManager$DeviceTypes;
import d0.z.d.m;

/* JADX INFO: compiled from: AudioOutputSelectionDialogViewModel.kt */
/* JADX INFO: loaded from: classes.dex */
public final class d$a$a extends d$a {
    public final DiscordAudioManager$DeviceTypes a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f48b;
    public final String c;
    public final boolean d;
    public final boolean e;
    public final boolean f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d$a$a(DiscordAudioManager$DeviceTypes discordAudioManager$DeviceTypes, boolean z2, String str, boolean z3, boolean z4, boolean z5) {
        super(null);
        m.checkNotNullParameter(discordAudioManager$DeviceTypes, "selectedAudioOutput");
        this.a = discordAudioManager$DeviceTypes;
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
        if (!(obj instanceof d$a$a)) {
            return false;
        }
        d$a$a d_a_a = (d$a$a) obj;
        return m.areEqual(this.a, d_a_a.a) && this.f48b == d_a_a.f48b && m.areEqual(this.c, d_a_a.c) && this.d == d_a_a.d && this.e == d_a_a.e && this.f == d_a_a.f;
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
        DiscordAudioManager$DeviceTypes discordAudioManager$DeviceTypes = this.a;
        int iHashCode = (discordAudioManager$DeviceTypes != null ? discordAudioManager$DeviceTypes.hashCode() : 0) * 31;
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
        StringBuilder sbU = b.d.b.a.a.U("Loaded(selectedAudioOutput=");
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
        return b.d.b.a.a.O(sbU, this.f, ")");
    }
}
