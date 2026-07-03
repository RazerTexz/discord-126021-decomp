package com.discord.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.viewbinding.ViewBinding;
import com.discord.C5419R;
import com.discord.views.NumericBadgingView;
import com.discord.views.calls.VolumeSliderView;
import com.google.android.material.textview.MaterialTextView;

/* JADX INFO: loaded from: classes.dex */
public final class VoiceControlsSheetViewBinding implements ViewBinding {

    /* JADX INFO: renamed from: a */
    @NonNull
    public final View f15591a;

    /* JADX INFO: renamed from: b */
    @NonNull
    public final ImageView f15592b;

    /* JADX INFO: renamed from: c */
    @NonNull
    public final FrameLayout f15593c;

    /* JADX INFO: renamed from: d */
    @NonNull
    public final ImageView f15594d;

    /* JADX INFO: renamed from: e */
    @NonNull
    public final TextView f15595e;

    /* JADX INFO: renamed from: f */
    @NonNull
    public final TextView f15596f;

    /* JADX INFO: renamed from: g */
    @NonNull
    public final ImageView f15597g;

    /* JADX INFO: renamed from: h */
    @NonNull
    public final ImageView f15598h;

    /* JADX INFO: renamed from: i */
    @NonNull
    public final TextView f15599i;

    /* JADX INFO: renamed from: j */
    @NonNull
    public final ImageView f15600j;

    /* JADX INFO: renamed from: k */
    @NonNull
    public final ImageView f15601k;

    /* JADX INFO: renamed from: l */
    @NonNull
    public final LinearLayout f15602l;

    /* JADX INFO: renamed from: m */
    @NonNull
    public final Button f15603m;

    /* JADX INFO: renamed from: n */
    @NonNull
    public final NumericBadgingView f15604n;

    /* JADX INFO: renamed from: o */
    @NonNull
    public final ImageView f15605o;

    /* JADX INFO: renamed from: p */
    @NonNull
    public final ImageView f15606p;

    /* JADX INFO: renamed from: q */
    @NonNull
    public final TextView f15607q;

    /* JADX INFO: renamed from: r */
    @NonNull
    public final CardView f15608r;

    /* JADX INFO: renamed from: s */
    @NonNull
    public final MaterialTextView f15609s;

    /* JADX INFO: renamed from: t */
    @NonNull
    public final ImageView f15610t;

    /* JADX INFO: renamed from: u */
    @NonNull
    public final TextView f15611u;

    /* JADX INFO: renamed from: v */
    @NonNull
    public final VolumeSliderView f15612v;

    /* JADX INFO: renamed from: w */
    @NonNull
    public final ImageView f15613w;

    public VoiceControlsSheetViewBinding(@NonNull View view, @NonNull ImageView imageView, @NonNull FrameLayout frameLayout, @NonNull ImageView imageView2, @NonNull TextView textView, @NonNull TextView textView2, @NonNull ImageView imageView3, @NonNull View view2, @NonNull ImageView imageView4, @NonNull TextView textView3, @NonNull ImageView imageView5, @NonNull ImageView imageView6, @NonNull LinearLayout linearLayout, @NonNull Button button, @NonNull NumericBadgingView numericBadgingView, @NonNull ImageView imageView7, @NonNull ImageView imageView8, @NonNull TextView textView4, @NonNull CardView cardView, @NonNull MaterialTextView materialTextView, @NonNull ImageView imageView9, @NonNull TextView textView5, @NonNull VolumeSliderView volumeSliderView, @NonNull ImageView imageView10) {
        this.f15591a = view;
        this.f15592b = imageView;
        this.f15593c = frameLayout;
        this.f15594d = imageView2;
        this.f15595e = textView;
        this.f15596f = textView2;
        this.f15597g = imageView3;
        this.f15598h = imageView4;
        this.f15599i = textView3;
        this.f15600j = imageView5;
        this.f15601k = imageView6;
        this.f15602l = linearLayout;
        this.f15603m = button;
        this.f15604n = numericBadgingView;
        this.f15605o = imageView7;
        this.f15606p = imageView8;
        this.f15607q = textView4;
        this.f15608r = cardView;
        this.f15609s = materialTextView;
        this.f15610t = imageView9;
        this.f15611u = textView5;
        this.f15612v = volumeSliderView;
        this.f15613w = imageView10;
    }

    @NonNull
    /* JADX INFO: renamed from: a */
    public static VoiceControlsSheetViewBinding m8402a(@NonNull LayoutInflater layoutInflater, @NonNull ViewGroup viewGroup) {
        layoutInflater.inflate(C5419R.layout.voice_controls_sheet_view, viewGroup);
        int i = C5419R.id.audio_output_button;
        ImageView imageView = (ImageView) viewGroup.findViewById(C5419R.id.audio_output_button);
        if (imageView != null) {
            i = C5419R.id.audio_output_container;
            FrameLayout frameLayout = (FrameLayout) viewGroup.findViewById(C5419R.id.audio_output_container);
            if (frameLayout != null) {
                i = C5419R.id.audio_output_more;
                ImageView imageView2 = (ImageView) viewGroup.findViewById(C5419R.id.audio_output_more);
                if (imageView2 != null) {
                    i = C5419R.id.audio_output_secondary_button;
                    TextView textView = (TextView) viewGroup.findViewById(C5419R.id.audio_output_secondary_button);
                    if (textView != null) {
                        i = C5419R.id.deafen_secondary_button;
                        TextView textView2 = (TextView) viewGroup.findViewById(C5419R.id.deafen_secondary_button);
                        if (textView2 != null) {
                            i = C5419R.id.disconnect_button;
                            ImageView imageView3 = (ImageView) viewGroup.findViewById(C5419R.id.disconnect_button);
                            if (imageView3 != null) {
                                i = C5419R.id.handle;
                                View viewFindViewById = viewGroup.findViewById(C5419R.id.handle);
                                if (viewFindViewById != null) {
                                    i = C5419R.id.invite_button;
                                    ImageView imageView4 = (ImageView) viewGroup.findViewById(C5419R.id.invite_button);
                                    if (imageView4 != null) {
                                        i = C5419R.id.invite_secondary_button;
                                        TextView textView3 = (TextView) viewGroup.findViewById(C5419R.id.invite_secondary_button);
                                        if (textView3 != null) {
                                            i = C5419R.id.move_to_audience_button;
                                            ImageView imageView5 = (ImageView) viewGroup.findViewById(C5419R.id.move_to_audience_button);
                                            if (imageView5 != null) {
                                                i = C5419R.id.mute_button;
                                                ImageView imageView6 = (ImageView) viewGroup.findViewById(C5419R.id.mute_button);
                                                if (imageView6 != null) {
                                                    i = C5419R.id.peek_container;
                                                    LinearLayout linearLayout = (LinearLayout) viewGroup.findViewById(C5419R.id.peek_container);
                                                    if (linearLayout != null) {
                                                        i = C5419R.id.push_to_talk_button;
                                                        Button button = (Button) viewGroup.findViewById(C5419R.id.push_to_talk_button);
                                                        if (button != null) {
                                                            i = C5419R.id.raise_hand_badge;
                                                            NumericBadgingView numericBadgingView = (NumericBadgingView) viewGroup.findViewById(C5419R.id.raise_hand_badge);
                                                            if (numericBadgingView != null) {
                                                                i = C5419R.id.raise_hand_button;
                                                                ImageView imageView7 = (ImageView) viewGroup.findViewById(C5419R.id.raise_hand_button);
                                                                if (imageView7 != null) {
                                                                    i = C5419R.id.screen_share_button;
                                                                    ImageView imageView8 = (ImageView) viewGroup.findViewById(C5419R.id.screen_share_button);
                                                                    if (imageView8 != null) {
                                                                        i = C5419R.id.screen_share_secondary_button;
                                                                        TextView textView4 = (TextView) viewGroup.findViewById(C5419R.id.screen_share_secondary_button);
                                                                        if (textView4 != null) {
                                                                            i = C5419R.id.secondary_actions_card;
                                                                            CardView cardView = (CardView) viewGroup.findViewById(C5419R.id.secondary_actions_card);
                                                                            if (cardView != null) {
                                                                                i = C5419R.id.stage_disconnect_button_large;
                                                                                MaterialTextView materialTextView = (MaterialTextView) viewGroup.findViewById(C5419R.id.stage_disconnect_button_large);
                                                                                if (materialTextView != null) {
                                                                                    i = C5419R.id.stop_watching_button;
                                                                                    ImageView imageView9 = (ImageView) viewGroup.findViewById(C5419R.id.stop_watching_button);
                                                                                    if (imageView9 != null) {
                                                                                        i = C5419R.id.stream_volume_label;
                                                                                        TextView textView5 = (TextView) viewGroup.findViewById(C5419R.id.stream_volume_label);
                                                                                        if (textView5 != null) {
                                                                                            i = C5419R.id.stream_volume_slider;
                                                                                            VolumeSliderView volumeSliderView = (VolumeSliderView) viewGroup.findViewById(C5419R.id.stream_volume_slider);
                                                                                            if (volumeSliderView != null) {
                                                                                                i = C5419R.id.video_button;
                                                                                                ImageView imageView10 = (ImageView) viewGroup.findViewById(C5419R.id.video_button);
                                                                                                if (imageView10 != null) {
                                                                                                    return new VoiceControlsSheetViewBinding(viewGroup, imageView, frameLayout, imageView2, textView, textView2, imageView3, viewFindViewById, imageView4, textView3, imageView5, imageView6, linearLayout, button, numericBadgingView, imageView7, imageView8, textView4, cardView, materialTextView, imageView9, textView5, volumeSliderView, imageView10);
                                                                                                }
                                                                                            }
                                                                                        }
                                                                                    }
                                                                                }
                                                                            }
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(viewGroup.getResources().getResourceName(i)));
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f15591a;
    }
}
