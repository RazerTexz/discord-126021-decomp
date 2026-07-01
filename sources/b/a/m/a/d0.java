package b.a.m.a;

import com.discord.models.domain.Model$JsonReader;
import com.discord.models.domain.Model$JsonReader$ItemFactory;
import com.discord.models.domain.ModelGuildFolder$Parser;

/* JADX INFO: compiled from: lambda */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class d0 implements Model$JsonReader$ItemFactory {
    public final /* synthetic */ Model$JsonReader a;

    public /* synthetic */ d0(Model$JsonReader model$JsonReader) {
        this.a = model$JsonReader;
    }

    @Override // com.discord.models.domain.Model$JsonReader$ItemFactory
    public final Object get() {
        return ModelGuildFolder$Parser.INSTANCE.parse(this.a);
    }
}
