package b.a.m.a;

import com.discord.api.guild.Guild;
import com.discord.models.deserialization.gson.InboundGatewayGsonParser;
import com.discord.models.domain.Model$JsonReader;
import com.discord.models.domain.Model$JsonReader$ItemFactory;

/* JADX INFO: compiled from: lambda */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class l implements Model$JsonReader$ItemFactory {
    public final /* synthetic */ Model$JsonReader a;

    public /* synthetic */ l(Model$JsonReader model$JsonReader) {
        this.a = model$JsonReader;
    }

    @Override // com.discord.models.domain.Model$JsonReader$ItemFactory
    public final Object get() {
        return (Guild) InboundGatewayGsonParser.fromJson(this.a, Guild.class);
    }
}
