package com.discord.widgets.voice.fullscreen;

import com.discord.api.voice.state.VoiceState;
import com.discord.models.domain.ModelApplicationStream;
import com.discord.stores.StoreVoiceParticipants$VoiceUser;
import com.discord.utilities.user.UserUtils;
import d0.z.d.m;
import java.util.Comparator;

/* JADX INFO: compiled from: WidgetCallFullscreenViewModel.kt */
/* JADX INFO: loaded from: classes.dex */
public final class WidgetCallFullscreenViewModel$createUserItemsComparator$1<T> implements Comparator<StoreVoiceParticipants$VoiceUser> {
    public final /* synthetic */ String $mySpectatingStreamKey;
    public final /* synthetic */ boolean $prioritizeSpectators;

    public WidgetCallFullscreenViewModel$createUserItemsComparator$1(String str, boolean z2) {
        this.$mySpectatingStreamKey = str;
        this.$prioritizeSpectators = z2;
    }

    @Override // java.util.Comparator
    public /* bridge */ /* synthetic */ int compare(StoreVoiceParticipants$VoiceUser storeVoiceParticipants$VoiceUser, StoreVoiceParticipants$VoiceUser storeVoiceParticipants$VoiceUser2) {
        return compare2(storeVoiceParticipants$VoiceUser, storeVoiceParticipants$VoiceUser2);
    }

    /* JADX INFO: renamed from: compare, reason: avoid collision after fix types in other method */
    public final int compare2(StoreVoiceParticipants$VoiceUser storeVoiceParticipants$VoiceUser, StoreVoiceParticipants$VoiceUser storeVoiceParticipants$VoiceUser2) {
        boolean z2 = false;
        boolean z3 = this.$mySpectatingStreamKey != null;
        ModelApplicationStream applicationStream = storeVoiceParticipants$VoiceUser.getApplicationStream();
        String encodedStreamKey = applicationStream != null ? applicationStream.getEncodedStreamKey() : null;
        ModelApplicationStream applicationStream2 = storeVoiceParticipants$VoiceUser2.getApplicationStream();
        String encodedStreamKey2 = applicationStream2 != null ? applicationStream2.getEncodedStreamKey() : null;
        boolean z4 = encodedStreamKey != null;
        boolean z5 = encodedStreamKey2 != null;
        VoiceState voiceState = storeVoiceParticipants$VoiceUser.getVoiceState();
        boolean z6 = voiceState != null && voiceState.getSelfVideo();
        VoiceState voiceState2 = storeVoiceParticipants$VoiceUser2.getVoiceState();
        boolean z7 = voiceState2 != null && voiceState2.getSelfVideo();
        boolean z8 = z3 && m.areEqual(encodedStreamKey, this.$mySpectatingStreamKey);
        if (z3 && m.areEqual(encodedStreamKey2, this.$mySpectatingStreamKey)) {
            z2 = true;
        }
        boolean z9 = this.$prioritizeSpectators;
        if (!z9 || !z8) {
            if (z9 && z2) {
                return 1;
            }
            if (!z9 || !z3 || !m.areEqual(storeVoiceParticipants$VoiceUser.getWatchingStream(), this.$mySpectatingStreamKey) || !(!m.areEqual(storeVoiceParticipants$VoiceUser2.getWatchingStream(), this.$mySpectatingStreamKey))) {
                if (this.$prioritizeSpectators && z3 && m.areEqual(storeVoiceParticipants$VoiceUser2.getWatchingStream(), this.$mySpectatingStreamKey) && (!m.areEqual(storeVoiceParticipants$VoiceUser.getWatchingStream(), this.$mySpectatingStreamKey))) {
                    return 1;
                }
                if (!z4 || z5) {
                    if (!z4 && z5) {
                        return 1;
                    }
                    if (!z6 || z7) {
                        if (z6 || !z7) {
                            return UserUtils.INSTANCE.compareUserNames(storeVoiceParticipants$VoiceUser.getUser(), storeVoiceParticipants$VoiceUser2.getUser(), storeVoiceParticipants$VoiceUser.getNickname(), storeVoiceParticipants$VoiceUser2.getNickname());
                        }
                        return 1;
                    }
                }
            }
        }
        return -1;
    }
}
