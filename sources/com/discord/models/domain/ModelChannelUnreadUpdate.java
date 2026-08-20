package com.discord.models.domain;

import java.io.IOException;
import java.util.List;
import kotlin.jvm.internal.Ref$ObjectRef;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;
import p658rx.functions.Action1;

/* JADX INFO: compiled from: ModelChannelUnreadUpdate.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class ModelChannelUnreadUpdate {
    private final List<ModelReadState> channelReadStates;

    /* JADX INFO: compiled from: ModelChannelUnreadUpdate.kt */
    public static final class Parser implements Model.Parser<ModelChannelUnreadUpdate> {
        public static final Parser INSTANCE = new Parser();

        private Parser() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.discord.models.domain.Model.Parser
        public ModelChannelUnreadUpdate parse(final Model.JsonReader reader) throws IOException {
            final Ref$ObjectRef ref$ObjectRefM844c0 = C1643a.m844c0(reader, "reader");
            ref$ObjectRefM844c0.element = null;
            reader.nextObject(new Action1<String>() { // from class: com.discord.models.domain.ModelChannelUnreadUpdate$Parser$parse$1
                @Override // p658rx.functions.Action1
                public final void call(String str) throws IOException {
                    if (str == null || str.hashCode() != -298662154 || !str.equals("channel_unread_updates")) {
                        reader.skipValue();
                        return;
                    }
                    Ref$ObjectRef ref$ObjectRef = ref$ObjectRefM844c0;
                    T t = (T) reader.nextList(new Model.JsonReader.ItemFactory<ModelReadState>() { // from class: com.discord.models.domain.ModelChannelUnreadUpdate$Parser$parse$1.1
                        /* JADX WARN: Can't rename method to resolve collision */
                        @Override // com.discord.models.domain.Model.JsonReader.ItemFactory
                        public final ModelReadState get() {
                            return ModelReadState.Parser.INSTANCE.parse(reader);
                        }
                    });
                    C12238m.checkNotNullExpressionValue(t, "reader.nextList { ModelR…te.Parser.parse(reader) }");
                    ref$ObjectRef.element = t;
                }
            });
            T t = ref$ObjectRefM844c0.element;
            if (t == 0) {
                C12238m.throwUninitializedPropertyAccessException("channelReadStates");
            }
            return new ModelChannelUnreadUpdate((List) t);
        }
    }

    public ModelChannelUnreadUpdate(List<ModelReadState> list) {
        C12238m.checkNotNullParameter(list, "channelReadStates");
        this.channelReadStates = list;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ModelChannelUnreadUpdate copy$default(ModelChannelUnreadUpdate modelChannelUnreadUpdate, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            list = modelChannelUnreadUpdate.channelReadStates;
        }
        return modelChannelUnreadUpdate.copy(list);
    }

    public final List<ModelReadState> component1() {
        return this.channelReadStates;
    }

    public final ModelChannelUnreadUpdate copy(List<ModelReadState> channelReadStates) {
        C12238m.checkNotNullParameter(channelReadStates, "channelReadStates");
        return new ModelChannelUnreadUpdate(channelReadStates);
    }

    public boolean equals(Object other) {
        if (this != other) {
            return (other instanceof ModelChannelUnreadUpdate) && C12238m.areEqual(this.channelReadStates, ((ModelChannelUnreadUpdate) other).channelReadStates);
        }
        return true;
    }

    public final List<ModelReadState> getChannelReadStates() {
        return this.channelReadStates;
    }

    public int hashCode() {
        List<ModelReadState> list = this.channelReadStates;
        if (list != null) {
            return list.hashCode();
        }
        return 0;
    }

    public String toString() {
        return C1643a.m824L(C1643a.m833U("ModelChannelUnreadUpdate(channelReadStates="), this.channelReadStates, ")");
    }
}
