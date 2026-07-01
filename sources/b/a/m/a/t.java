package b.a.m.a;

import com.discord.models.domain.Model$JsonReader;
import com.discord.models.domain.Model$JsonReader$ItemFactory;
import com.discord.models.domain.ModelPayload$VersionedModel;

/* JADX INFO: compiled from: lambda */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class t implements Model$JsonReader$ItemFactory {
    public final /* synthetic */ ModelPayload$VersionedModel a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Model$JsonReader f248b;

    public /* synthetic */ t(ModelPayload$VersionedModel modelPayload$VersionedModel, Model$JsonReader model$JsonReader) {
        this.a = modelPayload$VersionedModel;
        this.f248b = model$JsonReader;
    }

    @Override // com.discord.models.domain.Model$JsonReader$ItemFactory
    public final Object get() {
        return this.a.parseEntry(this.f248b);
    }
}
