package co.discord.media_engine;

import d0.z.d.Intrinsics3;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: compiled from: VoiceQuality.kt */
/* JADX INFO: loaded from: classes.dex */
public final class VoiceQuality {
    private Map<String, VoiceQuality3> _inboundStats = new LinkedHashMap();
    private VoiceQuality6 _outboundStats = new VoiceQuality6(0, 0);
    private VoiceQuality2 _duration = new VoiceQuality2(0, 0, 0, 0);

    public final void getBufferStats(Map<String, Object> result) {
        PlayoutMetric audioJitterBuffer;
        Intrinsics3.checkNotNullParameter(result, "result");
        Iterator<Map.Entry<String, VoiceQuality3>> it = this._inboundStats.entrySet().iterator();
        VoiceQuality4 bufferStats = null;
        while (it.hasNext()) {
            VoiceQuality3 value = it.next().getValue();
            if (bufferStats == null) {
                bufferStats = value.getBufferStats();
            } else {
                PlayoutMetric audioJitterBuffer2 = bufferStats.getAudioJitterBuffer();
                if (audioJitterBuffer2 != null && (audioJitterBuffer = value.getBufferStats().getAudioJitterBuffer()) != null && audioJitterBuffer.getP75() > audioJitterBuffer2.getP75()) {
                    bufferStats = value.getBufferStats();
                }
            }
        }
        VoiceQuality7.explodePlayoutMetric("audio_jitter_buffer", bufferStats != null ? bufferStats.getAudioJitterBuffer() : null, result);
        VoiceQuality7.explodePlayoutMetric("audio_jitter_target", bufferStats != null ? bufferStats.getAudioJitterTarget() : null, result);
        VoiceQuality7.explodePlayoutMetric("audio_jitter_delay", bufferStats != null ? bufferStats.getAudioJitterDelay() : null, result);
        VoiceQuality7.explodePlayoutMetric("relative_reception_delay", bufferStats != null ? bufferStats.getRelativeReceptionDelay() : null, result);
        VoiceQuality7.explodePlayoutMetric("relative_playout_delay", bufferStats != null ? bufferStats.getRelativePlayoutDelay() : null, result);
    }

    public final void getDurationStats(Map<String, Object> result) {
        Intrinsics3.checkNotNullParameter(result, "result");
        result.put("duration_listening", Integer.valueOf(this._duration.getListening()));
        result.put("duration_speaking", Integer.valueOf(this._duration.getSpeaking()));
        result.put("duration_participation", Integer.valueOf(this._duration.getParticipation()));
        result.put("duration_connected", Integer.valueOf(this._duration.getConnected()));
    }

    public final void getFrameOpStats(Map<String, Object> result) {
        Intrinsics3.checkNotNullParameter(result, "result");
        Iterator<Map.Entry<String, VoiceQuality3>> it = this._inboundStats.entrySet().iterator();
        Long lValueOf = null;
        Long lValueOf2 = null;
        Long lValueOf3 = null;
        Long lValueOf4 = null;
        Long lValueOf5 = null;
        Long lValueOf6 = null;
        Long lValueOf7 = null;
        while (it.hasNext()) {
            VoiceQuality3 value = it.next().getValue();
            Long silent = value.getFrameOpStats().getSilent();
            if (silent != null) {
                lValueOf = Long.valueOf((lValueOf != null ? lValueOf.longValue() : 0L) + silent.longValue());
            }
            Long normal = value.getFrameOpStats().getNormal();
            if (normal != null) {
                lValueOf2 = Long.valueOf((lValueOf2 != null ? lValueOf2.longValue() : 0L) + normal.longValue());
            }
            Long merged = value.getFrameOpStats().getMerged();
            if (merged != null) {
                lValueOf3 = Long.valueOf((lValueOf3 != null ? lValueOf3.longValue() : 0L) + merged.longValue());
            }
            Long expanded = value.getFrameOpStats().getExpanded();
            if (expanded != null) {
                lValueOf4 = Long.valueOf((lValueOf4 != null ? lValueOf4.longValue() : 0L) + expanded.longValue());
            }
            Long accelerated = value.getFrameOpStats().getAccelerated();
            if (accelerated != null) {
                lValueOf5 = Long.valueOf((lValueOf5 != null ? lValueOf5.longValue() : 0L) + accelerated.longValue());
            }
            Long preemptiveExpanded = value.getFrameOpStats().getPreemptiveExpanded();
            if (preemptiveExpanded != null) {
                lValueOf6 = Long.valueOf((lValueOf6 != null ? lValueOf6.longValue() : 0L) + preemptiveExpanded.longValue());
            }
            Long cng = value.getFrameOpStats().getCng();
            if (cng != null) {
                lValueOf7 = Long.valueOf((lValueOf7 != null ? lValueOf7.longValue() : 0L) + cng.longValue());
            }
        }
        if (lValueOf != null) {
            result.put("frame_op_silent", Long.valueOf(lValueOf.longValue()));
        }
        if (lValueOf2 != null) {
            result.put("frame_op_normal", Long.valueOf(lValueOf2.longValue()));
        }
        if (lValueOf3 != null) {
            result.put("frame_op_merged", Long.valueOf(lValueOf3.longValue()));
        }
        if (lValueOf4 != null) {
            result.put("frame_op_expanded", Long.valueOf(lValueOf4.longValue()));
        }
        if (lValueOf5 != null) {
            result.put("frame_op_accelerated", Long.valueOf(lValueOf5.longValue()));
        }
        if (lValueOf6 != null) {
            result.put("frame_op_preemptive_expanded", Long.valueOf(lValueOf6.longValue()));
        }
        if (lValueOf7 != null) {
            result.put("frame_op_cng", Long.valueOf(lValueOf7.longValue()));
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void getMosStats(Map<String, Object> result) {
        Intrinsics3.checkNotNullParameter(result, "result");
        Integer[] numArr = new Integer[5];
        Object obj = 0;
        numArr[0] = obj;
        numArr[1] = obj;
        numArr[2] = obj;
        numArr[3] = obj;
        numArr[4] = obj;
        Iterator<Map.Entry<String, VoiceQuality3>> it = this._inboundStats.entrySet().iterator();
        double mosSum = 0.0d;
        int mosCount = 0;
        while (it.hasNext()) {
            VoiceQuality3 value = it.next().getValue();
            mosSum += value.getMosSum();
            mosCount += value.getMosCount();
            for (int i = 0; i <= 4; i++) {
                numArr[i] = Integer.valueOf(value.getMosBuckets()[i].intValue() + numArr[i].intValue());
            }
        }
        result.put("mos_mean", mosCount > 0 ? Double.valueOf(mosSum / ((double) mosCount)) : 0);
        result.put("mos_1", numArr[1]);
        result.put("mos_2", numArr[2]);
        result.put("mos_3", numArr[3]);
        result.put("mos_4", numArr[4]);
    }

    public final void getPacketStats(Map<String, Object> result) {
        Intrinsics3.checkNotNullParameter(result, "result");
        Iterator<Map.Entry<String, VoiceQuality3>> it = this._inboundStats.entrySet().iterator();
        long packetsReceived = 0;
        long packetsLost = 0;
        while (it.hasNext()) {
            VoiceQuality3 value = it.next().getValue();
            packetsReceived += value.getPacketsReceived();
            packetsLost += value.getPacketsLost();
        }
        result.put("packets_sent", Long.valueOf(this._outboundStats.getPacketsSent()));
        result.put("packets_sent_lost", Integer.valueOf(this._outboundStats.getPacketsLost()));
        result.put("packets_received", Long.valueOf(packetsReceived));
        result.put("packets_received_lost", Long.valueOf(packetsLost));
    }

    public final void update(Stats stats) {
        boolean z2;
        int i;
        boolean z3;
        long j;
        VoiceQuality3 voiceQuality3;
        double d;
        Intrinsics3.checkNotNullParameter(stats, "stats");
        VoiceQuality2 voiceQuality2 = this._duration;
        voiceQuality2.setConnected(voiceQuality2.getConnected() + 1);
        long packetsSent = this._outboundStats.getPacketsSent();
        Iterator<Map.Entry<String, VoiceQuality3>> it = this._inboundStats.entrySet().iterator();
        long j2 = 0;
        long packetsReceived = 0;
        while (it.hasNext()) {
            packetsReceived += it.next().getValue().getPacketsReceived();
        }
        OutboundRtpAudio outboundRtpAudio = stats.getOutboundRtpAudio();
        this._outboundStats = outboundRtpAudio != null ? new VoiceQuality6(outboundRtpAudio.getPacketsSent(), outboundRtpAudio.getPacketsLost()) : new VoiceQuality6(0L, 0);
        Iterator<Map.Entry<String, InboundRtpAudio>> it2 = stats.getInboundRtpAudio().entrySet().iterator();
        while (it2.hasNext()) {
            Map.Entry<String, InboundRtpAudio> next = it2.next();
            String key = next.getKey();
            InboundRtpAudio value = next.getValue();
            Transport transport = stats.getTransport();
            int ping = transport != null ? transport.getPing() : 0;
            long packetsReceived2 = value.getPacketsReceived();
            long packetsLost = value.getPacketsLost();
            int jitterBuffer = (int) value.getJitterBuffer();
            VoiceQuality4 voiceQuality4 = new VoiceQuality4(value.getAudioJitterBuffer(), value.getAudioJitterTarget(), value.getAudioJitterDelay(), value.getRelativeReceptionDelay(), value.getRelativePlayoutDelay());
            VoiceQuality5 voiceQuality5 = new VoiceQuality5(value.getOpSilence(), value.getOpNormal(), value.getOpMerge(), value.getOpExpand(), value.getOpAccelerate(), value.getOpPreemptiveExpand(), value.getOpCNG());
            Map<String, VoiceQuality3> map = this._inboundStats;
            VoiceQuality3 voiceQuality6 = map.get(key);
            if (voiceQuality6 != null) {
                long packetsReceived3 = packetsReceived2 - voiceQuality6.getPacketsReceived();
                long packetsLost2 = packetsLost - voiceQuality6.getPacketsLost();
                Integer[] mosBuckets = voiceQuality6.getMosBuckets();
                j = 0;
                if (packetsReceived3 <= 0 || packetsLost2 < 0) {
                    d = 0.0d;
                } else {
                    double d_calculateMos = VoiceQuality7._calculateMos(ping + jitterBuffer, VoiceQuality7.clamp(packetsLost2 / (packetsReceived3 + packetsLost2), 0.0d, 1.0d));
                    int iFloor = (int) Math.floor(d_calculateMos);
                    mosBuckets[iFloor] = Integer.valueOf(mosBuckets[iFloor].intValue() + 1);
                    d = d_calculateMos;
                }
                voiceQuality3 = new VoiceQuality3(packetsReceived2, packetsLost, d, voiceQuality6.getMosSum() + d, voiceQuality6.getMosCount() + (d > ((double) 0) ? 1 : 0), mosBuckets, voiceQuality4, voiceQuality5);
            } else {
                it2 = it2;
                j = j2;
                voiceQuality3 = new VoiceQuality3(packetsReceived2, packetsLost, 0.0d, 0.0d, 0, new Integer[]{0, 0, 0, 0, 0}, voiceQuality4, voiceQuality5);
            }
            map.put(key, voiceQuality3);
            it2 = it2;
            j2 = j;
        }
        long j3 = j2;
        if (this._outboundStats.getPacketsSent() > packetsSent) {
            VoiceQuality2 voiceQuality7 = this._duration;
            voiceQuality7.setSpeaking(voiceQuality7.getSpeaking() + 1);
            z2 = true;
        } else {
            z2 = false;
        }
        Iterator<Map.Entry<String, VoiceQuality3>> it3 = this._inboundStats.entrySet().iterator();
        long packetsReceived4 = j3;
        while (it3.hasNext()) {
            packetsReceived4 += it3.next().getValue().getPacketsReceived();
        }
        if (packetsReceived4 > packetsReceived) {
            VoiceQuality2 voiceQuality8 = this._duration;
            i = 1;
            voiceQuality8.setListening(voiceQuality8.getListening() + 1);
            z3 = true;
        } else {
            i = 1;
            z3 = false;
        }
        if (z2 || z3) {
            VoiceQuality2 voiceQuality9 = this._duration;
            voiceQuality9.setParticipation(voiceQuality9.getParticipation() + i);
        }
    }
}
