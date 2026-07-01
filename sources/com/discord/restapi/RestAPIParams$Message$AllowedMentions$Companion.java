package com.discord.restapi;

import com.discord.api.message.allowedmentions.MessageAllowedMentions;
import com.discord.api.message.allowedmentions.MessageAllowedMentionsTypes;
import d0.t.o;
import d0.z.d.m;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: RestAPIParams.kt */
/* JADX INFO: loaded from: classes.dex */
public final class RestAPIParams$Message$AllowedMentions$Companion {
    private RestAPIParams$Message$AllowedMentions$Companion() {
    }

    public final RestAPIParams$Message$AllowedMentions create(MessageAllowedMentions model) {
        ArrayList arrayList;
        m.checkNotNullParameter(model, "model");
        List<MessageAllowedMentionsTypes> listA = model.a();
        if (listA != null) {
            arrayList = new ArrayList(o.collectionSizeOrDefault(listA, 10));
            Iterator<T> it = listA.iterator();
            while (it.hasNext()) {
                arrayList.add(((MessageAllowedMentionsTypes) it.next()).getApiStringRepresentation());
            }
        } else {
            arrayList = null;
        }
        return new RestAPIParams$Message$AllowedMentions(arrayList, model.d(), model.c(), model.getRepliedUser());
    }

    public /* synthetic */ RestAPIParams$Message$AllowedMentions$Companion(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
