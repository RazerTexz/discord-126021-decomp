package d0.e0.p.d.m0.p;

import com.discord.widgets.chat.input.MentionUtilsKt;
import d0.z.d.m;
import d0.z.d.o;
import java.util.ArrayList;
import java.util.Map$Entry;
import java.util.Objects;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: JavaTypeEnhancementState.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class e$b extends o implements Function0<String[]> {
    public final /* synthetic */ e this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e$b(e eVar) {
        super(0);
        this.this$0 = eVar;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ String[] invoke() {
        return invoke2();
    }

    @Override // kotlin.jvm.functions.Function0
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final String[] invoke2() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(this.this$0.getGlobalJsr305Level().getDescription());
        h migrationLevelForJsr305 = this.this$0.getMigrationLevelForJsr305();
        if (migrationLevelForJsr305 != null) {
            arrayList.add(m.stringPlus("under-migration:", migrationLevelForJsr305.getDescription()));
        }
        for (Map$Entry<String, h> map$Entry : this.this$0.getUserDefinedLevelForSpecificJsr305Annotation().entrySet()) {
            StringBuilder sbQ = b.d.b.a.a.Q(MentionUtilsKt.MENTIONS_CHAR);
            sbQ.append(map$Entry.getKey());
            sbQ.append(MentionUtilsKt.EMOJIS_AND_STICKERS_CHAR);
            sbQ.append(map$Entry.getValue().getDescription());
            arrayList.add(sbQ.toString());
        }
        Object[] array = arrayList.toArray(new String[0]);
        Objects.requireNonNull(array, "null cannot be cast to non-null type kotlin.Array<T>");
        return (String[]) array;
    }
}
