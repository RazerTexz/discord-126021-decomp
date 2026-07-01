package com.discord.models.domain;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import b.d.b.a.outline;
import com.discord.api.voice.state.VoiceState;
import com.discord.models.deserialization.gson.InboundGatewayGsonParser;
import com.discord.models.domain.Model;
import com.discord.models.domain.ModelCall;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class ModelCall implements Model {
    private static final List<Long> EMPTY_RINGING = new ArrayList();
    public static final /* synthetic */ int j = 0;
    private long channelId;
    private long messageId;
    private String region;
    private List<Long> ringing;
    private boolean unavailable;

    @Nullable
    private List<VoiceState> voiceStates;

    public static class Ringable implements Model {
        private boolean ringable;

        @Override // com.discord.models.domain.Model
        public void assignField(Model.JsonReader jsonReader) throws IOException {
            String strNextName = jsonReader.nextName();
            strNextName.hashCode();
            if (strNextName.equals("ringable")) {
                this.ringable = jsonReader.nextBoolean(this.ringable);
            } else {
                jsonReader.skipValue();
            }
        }

        public boolean canEqual(Object obj) {
            return obj instanceof Ringable;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof Ringable)) {
                return false;
            }
            Ringable ringable = (Ringable) obj;
            return ringable.canEqual(this) && isRingable() == ringable.isRingable();
        }

        public int hashCode() {
            return 59 + (isRingable() ? 79 : 97);
        }

        public boolean isRingable() {
            return this.ringable;
        }

        public String toString() {
            StringBuilder sbU = outline.U("ModelCall.Ringable(ringable=");
            sbU.append(isRingable());
            sbU.append(")");
            return sbU.toString();
        }
    }

    @Override // com.discord.models.domain.Model
    public void assignField(final Model.JsonReader jsonReader) throws IOException {
        String strNextName = jsonReader.nextName();
        strNextName.hashCode();
        switch (strNextName) {
            case "channel_id":
                this.channelId = jsonReader.nextLong(this.channelId);
                break;
            case "message_id":
                this.messageId = jsonReader.nextLong(this.messageId);
                break;
            case "region":
                this.region = jsonReader.nextString(this.region);
                break;
            case "unavailable":
                this.unavailable = jsonReader.nextBoolean(this.unavailable);
                break;
            case "voice_states":
                this.voiceStates = jsonReader.nextList(new Model.JsonReader.ItemFactory() { // from class: b.a.m.a.j
                    @Override // com.discord.models.domain.Model.JsonReader.ItemFactory
                    public final Object get() {
                        Model.JsonReader jsonReader2 = jsonReader;
                        int i = ModelCall.j;
                        return (VoiceState) InboundGatewayGsonParser.fromJson(jsonReader2, VoiceState.class);
                    }
                });
                break;
            case "ringing":
                this.ringing = jsonReader.nextList(new Model.JsonReader.ItemFactory() { // from class: b.a.m.a.i
                    @Override // com.discord.models.domain.Model.JsonReader.ItemFactory
                    public final Object get() {
                        Model.JsonReader jsonReader2 = jsonReader;
                        int i = ModelCall.j;
                        return Long.valueOf(jsonReader2.nextLong(1L));
                    }
                });
                break;
            default:
                jsonReader.skipValue();
                break;
        }
    }

    public boolean canEqual(Object obj) {
        return obj instanceof ModelCall;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ModelCall)) {
            return false;
        }
        ModelCall modelCall = (ModelCall) obj;
        if (!modelCall.canEqual(this) || getChannelId() != modelCall.getChannelId() || getMessageId() != modelCall.getMessageId() || isUnavailable() != modelCall.isUnavailable()) {
            return false;
        }
        String region = getRegion();
        String region2 = modelCall.getRegion();
        if (region != null ? !region.equals(region2) : region2 != null) {
            return false;
        }
        List<Long> ringing = getRinging();
        List<Long> ringing2 = modelCall.getRinging();
        if (ringing != null ? !ringing.equals(ringing2) : ringing2 != null) {
            return false;
        }
        List<VoiceState> voiceStates = getVoiceStates();
        List<VoiceState> voiceStates2 = modelCall.getVoiceStates();
        return voiceStates != null ? voiceStates.equals(voiceStates2) : voiceStates2 == null;
    }

    public long getChannelId() {
        return this.channelId;
    }

    public long getMessageId() {
        return this.messageId;
    }

    public String getRegion() {
        return this.region;
    }

    @NonNull
    public List<Long> getRinging() {
        List<Long> list = this.ringing;
        return list != null ? list : EMPTY_RINGING;
    }

    @Nullable
    public List<VoiceState> getVoiceStates() {
        return this.voiceStates;
    }

    public int hashCode() {
        long channelId = getChannelId();
        long messageId = getMessageId();
        int i = ((((((int) (channelId ^ (channelId >>> 32))) + 59) * 59) + ((int) ((messageId >>> 32) ^ messageId))) * 59) + (isUnavailable() ? 79 : 97);
        String region = getRegion();
        int iHashCode = (i * 59) + (region == null ? 43 : region.hashCode());
        List<Long> ringing = getRinging();
        int iHashCode2 = (iHashCode * 59) + (ringing == null ? 43 : ringing.hashCode());
        List<VoiceState> voiceStates = getVoiceStates();
        return (iHashCode2 * 59) + (voiceStates != null ? voiceStates.hashCode() : 43);
    }

    public boolean isUnavailable() {
        return this.unavailable;
    }

    public String toString() {
        StringBuilder sbU = outline.U("ModelCall(channelId=");
        sbU.append(getChannelId());
        sbU.append(", messageId=");
        sbU.append(getMessageId());
        sbU.append(", region=");
        sbU.append(getRegion());
        sbU.append(", unavailable=");
        sbU.append(isUnavailable());
        sbU.append(", ringing=");
        sbU.append(getRinging());
        sbU.append(", voiceStates=");
        sbU.append(getVoiceStates());
        sbU.append(")");
        return sbU.toString();
    }
}
