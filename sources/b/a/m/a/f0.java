package b.a.m.a;

import com.discord.models.domain.Model$JsonReader$KeySelector;
import com.discord.models.experiments.dto.UserExperimentDto;

/* JADX INFO: compiled from: lambda */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class f0 implements Model$JsonReader$KeySelector {
    public static final /* synthetic */ f0 a = new f0();

    @Override // com.discord.models.domain.Model$JsonReader$KeySelector
    public final Object get(Object obj) {
        return Long.valueOf(((UserExperimentDto) obj).getNameHash());
    }
}
