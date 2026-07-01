package com.discord.views;

import b.d.b.a.a;
import com.discord.stores.StoreVoiceParticipants$VoiceUser;
import d0.o;
import d0.t.u;
import j0.k.b;
import java.util.ArrayList;
import java.util.List;
import kotlin.Pair;

/* JADX INFO: compiled from: OverlayMenuBubbleDialog.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class OverlayMenuBubbleDialog$c<T, R> implements b<List<? extends StoreVoiceParticipants$VoiceUser>, Pair<? extends List<? extends StoreVoiceParticipants$VoiceUser>, ? extends Integer>> {
    public static final OverlayMenuBubbleDialog$c j = new OverlayMenuBubbleDialog$c();

    @Override // j0.k.b
    public Pair<? extends List<? extends StoreVoiceParticipants$VoiceUser>, ? extends Integer> call(List<? extends StoreVoiceParticipants$VoiceUser> list) {
        List<? extends StoreVoiceParticipants$VoiceUser> list2 = list;
        ArrayList arrayListA0 = a.a0(list2, "voiceUsers");
        for (T t : list2) {
            if (!((StoreVoiceParticipants$VoiceUser) t).isMe()) {
                arrayListA0.add(t);
            }
        }
        int size = arrayListA0.size();
        return (size >= 0 && 3 >= size) ? o.to(arrayListA0, 0) : o.to(u.take(arrayListA0, 3), Integer.valueOf(arrayListA0.size() - 3));
    }
}
