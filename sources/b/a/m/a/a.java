package b.a.m.a;

import com.discord.models.domain.Model;

/* JADX INFO: compiled from: lambda */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class a implements Model.JsonReader.ItemFactory {
    public final /* synthetic */ Model.JsonReader a;

    @Override // com.discord.models.domain.Model.JsonReader.ItemFactory
    public final Object get() {
        return this.a.nextLongOrNull();
    }
}
