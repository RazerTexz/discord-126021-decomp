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
import com.discord.R$id;
import com.discord.R$layout;
import com.discord.views.NumericBadgingView;
import com.discord.views.calls.VolumeSliderView;
import com.google.android.material.textview.MaterialTextView;

/* JADX INFO: loaded from: classes.dex */
public final class VoiceControlsSheetViewBinding implements ViewBinding {

    @NonNull
    public final View a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final ImageView f2217b;

    @NonNull
    public final FrameLayout c;

    @NonNull
    public final ImageView d;

    @NonNull
    public final TextView e;

    @NonNull
    public final TextView f;

    @NonNull
    public final ImageView g;

    @NonNull
    public final ImageView h;

    @NonNull
    public final TextView i;

    @NonNull
    public final ImageView j;

    @NonNull
    public final ImageView k;

    @NonNull
    public final LinearLayout l;

    @NonNull
    public final Button m;

    @NonNull
    public final NumericBadgingView n;

    @NonNull
    public final ImageView o;

    @NonNull
    public final ImageView p;

    @NonNull
    public final TextView q;

    @NonNull
    public final CardView r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    @NonNull
    public final MaterialTextView f2218s;

    @NonNull
    public final ImageView t;

    @NonNull
    public final TextView u;

    @NonNull
    public final VolumeSliderView v;

    @NonNull
    public final ImageView w;

    public VoiceControlsSheetViewBinding(@NonNull View view, @NonNull ImageView imageView, @NonNull FrameLayout frameLayout, @NonNull ImageView imageView2, @NonNull TextView textView, @NonNull TextView textView2, @NonNull ImageView imageView3, @NonNull View view2, @NonNull ImageView imageView4, @NonNull TextView textView3, @NonNull ImageView imageView5, @NonNull ImageView imageView6, @NonNull LinearLayout linearLayout, @NonNull Button button, @NonNull NumericBadgingView numericBadgingView, @NonNull ImageView imageView7, @NonNull ImageView imageView8, @NonNull TextView textView4, @NonNull CardView cardView, @NonNull MaterialTextView materialTextView, @NonNull ImageView imageView9, @NonNull TextView textView5, @NonNull VolumeSliderView volumeSliderView, @NonNull ImageView imageView10) {
        this.a = view;
        this.f2217b = imageView;
        this.c = frameLayout;
        this.d = imageView2;
        this.e = textView;
        this.f = textView2;
        this.g = imageView3;
        this.h = imageView4;
        this.i = textView3;
        this.j = imageView5;
        this.k = imageView6;
        this.l = linearLayout;
        this.m = button;
        this.n = numericBadgingView;
        this.o = imageView7;
        this.p = imageView8;
        this.q = textView4;
        this.r = cardView;
        this.f2218s = materialTextView;
        this.t = imageView9;
        this.u = textView5;
        this.v = volumeSliderView;
        this.w = imageView10;
    }

    @NonNull
    public static VoiceControlsSheetViewBinding a(@NonNull LayoutInflater layoutInflater, @NonNull ViewGroup viewGroup) {
        layoutInflater.inflate(R$layout.voice_controls_sheet_view, viewGroup);
        int i = R$id.audio_output_button;
        ImageView imageView = (ImageView) viewGroup.findViewById(R$id.audio_output_button);
        if (imageView != null) {
            i = R$id.audio_output_container;
            FrameLayout frameLayout = (FrameLayout) viewGroup.findViewById(R$id.audio_output_container);
            if (frameLayout != null) {
                i = R$id.audio_output_more;
                ImageView imageView2 = (ImageView) viewGroup.findViewById(R$id.audio_output_more);
                if (imageView2 != null) {
                    i = R$id.audio_output_secondary_button;
                    TextView textView = (TextView) viewGroup.findViewById(R$id.audio_output_secondary_button);
                    if (textView != null) {
                        i = R$id.deafen_secondary_button;
                        TextView textView2 = (TextView) viewGroup.findViewById(R$id.deafen_secondary_button);
                        if (textView2 != null) {
                            i = R$id.disconnect_button;
                            ImageView imageView3 = (ImageView) viewGroup.findViewById(R$id.disconnect_button);
                            if (imageView3 != null) {
                                i = R$id.handle;
                                View viewFindViewById = viewGroup.findViewById(R$id.handle);
                                if (viewFindViewById != null) {
                                    i = R$id.invite_button;
                                    ImageView imageView4 = (ImageView) viewGroup.findViewById(R$id.invite_button);
                                    if (imageView4 != null) {
                                        i = R$id.invite_secondary_button;
                                        TextView textView3 = (TextView) viewGroup.findViewById(R$id.invite_secondary_button);
                                        if (textView3 != null) {
                                            i = R$id.move_to_audience_button;
                                            ImageView imageView5 = (ImageView) viewGroup.findViewById(R$id.move_to_audience_button);
                                            if (imageView5 != null) {
                                                i = R$id.mute_button;
                                                ImageView imageView6 = (ImageView) viewGroup.findViewById(R$id.mute_button);
                                                if (imageView6 != null) {
                                                    i = R$id.peek_container;
                                                    LinearLayout linearLayout = (LinearLayout) viewGroup.findViewById(R$id.peek_container);
                                                    if (linearLayout != null) {
                                                        i = R$id.push_to_talk_button;
                                                        Button button = (Button) viewGroup.findViewById(R$id.push_to_talk_button);
                                                        if (button != null) {
                                                            i = R$id.raise_hand_badge;
                                                            NumericBadgingView numericBadgingView = (NumericBadgingView) viewGroup.findViewById(R$id.raise_hand_badge);
                                                            if (numericBadgingView != null) {
                                                                i = R$id.raise_hand_button;
                                                                ImageView imageView7 = (ImageView) viewGroup.findViewById(R$id.raise_hand_button);
                                                                if (imageView7 != null) {
                                                                    i = R$id.screen_share_button;
                                                                    ImageView imageView8 = (ImageView) viewGroup.findViewById(R$id.screen_share_button);
                                                                    if (imageView8 != null) {
                                                                        i = R$id.screen_share_secondary_button;
                                                                        TextView textView4 = (TextView) viewGroup.findViewById(R$id.screen_share_secondary_button);
                                                                        if (textView4 != null) {
                                                                            i = R$id.secondary_actions_card;
                                                                            CardView cardView = (CardView) viewGroup.findViewById(R$id.secondary_actions_card);
                                                                            if (cardView != null) {
                                                                                i = R$id.stage_disconnect_button_large;
                                                                                MaterialTextView materialTextView = (MaterialTextView) viewGroup.findViewById(R$id.stage_disconnect_button_large);
                                                                                if (materialTextView != null) {
                                                                                    i = R$id.stop_watching_button;
                                                                                    ImageView imageView9 = (ImageView) viewGroup.findViewById(R$id.stop_watching_button);
                                                                                    if (imageView9 != null) {
                                                                                        i = R$id.stream_volume_label;
                                                                                        TextView textView5 = (TextView) viewGroup.findViewById(R$id.stream_volume_label);
                                                                                        if (textView5 != null) {
                                                                                            i = R$id.stream_volume_slider;
                                                                                            VolumeSliderView volumeSliderView = (VolumeSliderView) viewGroup.findViewById(R$id.stream_volume_slider);
                                                                                            if (volumeSliderView != null) {
                                                                                                i = R$id.video_button;
                                                                                                ImageView imageView10 = (ImageView) viewGroup.findViewById(R$id.video_button);
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
        return this.a;
    }
}
