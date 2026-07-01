package android.support.v4.media.session;

import android.media.session.PlaybackState;
import android.media.session.PlaybackState$Builder;
import android.media.session.PlaybackState$CustomAction;
import android.media.session.PlaybackState$CustomAction$Builder;
import android.os.Bundle;
import androidx.annotation.DoNotInline;
import androidx.annotation.RequiresApi;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
@RequiresApi(21)
public class PlaybackStateCompat$b {
    @DoNotInline
    public static void a(PlaybackState$Builder playbackState$Builder, PlaybackState$CustomAction playbackState$CustomAction) {
        playbackState$Builder.addCustomAction(playbackState$CustomAction);
    }

    @DoNotInline
    public static PlaybackState$CustomAction b(PlaybackState$CustomAction$Builder playbackState$CustomAction$Builder) {
        return playbackState$CustomAction$Builder.build();
    }

    @DoNotInline
    public static PlaybackState c(PlaybackState$Builder playbackState$Builder) {
        return playbackState$Builder.build();
    }

    @DoNotInline
    public static PlaybackState$Builder d() {
        return new PlaybackState$Builder();
    }

    @DoNotInline
    public static PlaybackState$CustomAction$Builder e(String str, CharSequence charSequence, int i) {
        return new PlaybackState$CustomAction$Builder(str, charSequence, i);
    }

    @DoNotInline
    public static String f(PlaybackState$CustomAction playbackState$CustomAction) {
        return playbackState$CustomAction.getAction();
    }

    @DoNotInline
    public static long g(PlaybackState playbackState) {
        return playbackState.getActions();
    }

    @DoNotInline
    public static long h(PlaybackState playbackState) {
        return playbackState.getActiveQueueItemId();
    }

    @DoNotInline
    public static long i(PlaybackState playbackState) {
        return playbackState.getBufferedPosition();
    }

    @DoNotInline
    public static List<PlaybackState$CustomAction> j(PlaybackState playbackState) {
        return playbackState.getCustomActions();
    }

    @DoNotInline
    public static CharSequence k(PlaybackState playbackState) {
        return playbackState.getErrorMessage();
    }

    @DoNotInline
    public static Bundle l(PlaybackState$CustomAction playbackState$CustomAction) {
        return playbackState$CustomAction.getExtras();
    }

    @DoNotInline
    public static int m(PlaybackState$CustomAction playbackState$CustomAction) {
        return playbackState$CustomAction.getIcon();
    }

    @DoNotInline
    public static long n(PlaybackState playbackState) {
        return playbackState.getLastPositionUpdateTime();
    }

    @DoNotInline
    public static CharSequence o(PlaybackState$CustomAction playbackState$CustomAction) {
        return playbackState$CustomAction.getName();
    }

    @DoNotInline
    public static float p(PlaybackState playbackState) {
        return playbackState.getPlaybackSpeed();
    }

    @DoNotInline
    public static long q(PlaybackState playbackState) {
        return playbackState.getPosition();
    }

    @DoNotInline
    public static int r(PlaybackState playbackState) {
        return playbackState.getState();
    }

    @DoNotInline
    public static void s(PlaybackState$Builder playbackState$Builder, long j) {
        playbackState$Builder.setActions(j);
    }

    @DoNotInline
    public static void t(PlaybackState$Builder playbackState$Builder, long j) {
        playbackState$Builder.setActiveQueueItemId(j);
    }

    @DoNotInline
    public static void u(PlaybackState$Builder playbackState$Builder, long j) {
        playbackState$Builder.setBufferedPosition(j);
    }

    @DoNotInline
    public static void v(PlaybackState$Builder playbackState$Builder, CharSequence charSequence) {
        playbackState$Builder.setErrorMessage(charSequence);
    }

    @DoNotInline
    public static void w(PlaybackState$CustomAction$Builder playbackState$CustomAction$Builder, Bundle bundle) {
        playbackState$CustomAction$Builder.setExtras(bundle);
    }

    @DoNotInline
    public static void x(PlaybackState$Builder playbackState$Builder, int i, long j, float f, long j2) {
        playbackState$Builder.setState(i, j, f, j2);
    }
}
