package b.a.y.o0;

import com.discord.utilities.mg_recycler.MGRecyclerDataPayload;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: SpeakersItem.kt */
/* JADX INFO: loaded from: classes2.dex */
public abstract class d implements MGRecyclerDataPayload {
    public final String j;
    public final int k;

    public d(String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this.j = str;
        this.k = i;
    }

    @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload, com.discord.utilities.recycler.DiffKeyProvider
    public String getKey() {
        return this.j;
    }

    @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload
    public int getType() {
        return this.k;
    }
}
