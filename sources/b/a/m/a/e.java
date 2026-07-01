package b.a.m.a;

import com.discord.models.domain.Model$JsonReader;
import com.discord.models.domain.Model$JsonReader$ItemFactory;
import com.discord.models.domain.ModelWebhook;

/* JADX INFO: compiled from: lambda */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class e implements Model$JsonReader$ItemFactory {
    public final /* synthetic */ Model$JsonReader a;

    public /* synthetic */ e(Model$JsonReader model$JsonReader) {
        this.a = model$JsonReader;
    }

    @Override // com.discord.models.domain.Model$JsonReader$ItemFactory
    public final Object get() {
        return (ModelWebhook) this.a.parse(new ModelWebhook());
    }
}
