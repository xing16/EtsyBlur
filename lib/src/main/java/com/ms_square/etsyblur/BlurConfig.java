package com.ms_square.etsyblur;

import android.graphics.Color;
import android.support.annotation.ColorInt;
import android.support.annotation.NonNull;

/**
 * BlurConfig.java
 *
 * @author Manabu-GT on 3/17/17.
 */
public class BlurConfig {

    public static final int DEFAULT_RADIUS = 10;
    public static final int DEFAULT_DOWN_SCALE_FACTOR = 4;
    public static final int DEFAULT_OVERLAY_COLOR_TO_BLUR = Color.TRANSPARENT;
    public static final boolean DEFAULT_ALLOW_FALLBACK = true;
    public static final AsyncPolicy DEFAULT_ASYNC_POLICY = new SimpleAsyncPolicy();
    public static final boolean DEFAULT_DEBUG = false;

    public static final BlurConfig DEFAULT_CONFIG = new BlurConfig(DEFAULT_RADIUS,
            DEFAULT_DOWN_SCALE_FACTOR, DEFAULT_OVERLAY_COLOR_TO_BLUR, DEFAULT_ALLOW_FALLBACK,
            DEFAULT_ASYNC_POLICY, DEFAULT_DEBUG);

    private final int radius;

    private final int downScaleFactor;

    @ColorInt
    private final int overlayColorToBlur;

    private final boolean allowFallback;

    private final AsyncPolicy asyncPolicy;

    private final boolean debug;

    private BlurConfig(int radius, int downScaleFactor, @ColorInt int overlayColorToBlur,
                       boolean allowFallback, @NonNull AsyncPolicy asyncPolicy, boolean debug) {
        this.radius = radius;
        this.downScaleFactor = downScaleFactor;
        this.overlayColorToBlur = overlayColorToBlur;
        this.allowFallback = allowFallback;
        this.asyncPolicy = asyncPolicy;
        this.debug = debug;
    }

    public int radius() {
        return radius;
    }

    public int downScaleFactor() {
        return downScaleFactor;
    }

    public int overlayColorToBlur() {
        return overlayColorToBlur;
    }

    public boolean allowFallback() {
        return allowFallback;
    }

    public AsyncPolicy asyncPolicy() {
        return asyncPolicy;
    }

    public boolean debug() {
        return debug;
    }

    public static void checkRadius(int radius) {
        if (radius <= 0 || radius > 25) {
            throw new IllegalArgumentException("radius must be greater than 0 and less than or equal to 25");
        }
    }

    public static void checkDownScaleFactor(int downScaleFactor) {
        if (downScaleFactor <= 0) {
            throw new IllegalArgumentException("downScaleFactor must be greater than 0.");
        }
    }

    public static class Builder {

        private int radius;

        private int downScaleFactor;

        @ColorInt
        private int overlayColorToBlur;

        private boolean allowFallback;

        private AsyncPolicy asyncPolicy;

        private boolean debug;

        public Builder() {
            radius = DEFAULT_RADIUS;
            downScaleFactor = DEFAULT_DOWN_SCALE_FACTOR;
            overlayColorToBlur = DEFAULT_OVERLAY_COLOR_TO_BLUR;
            allowFallback = DEFAULT_ALLOW_FALLBACK;
            asyncPolicy = DEFAULT_ASYNC_POLICY;
            debug = DEFAULT_DEBUG;
        }

        public Builder radius(int radius) {
            checkRadius(radius);
            this.radius = radius;
            return this;
        }

        public Builder downScaleFactor(int downScaleFactor) {
            checkDownScaleFactor(downScaleFactor);
            this.downScaleFactor = downScaleFactor;
            return this;
        }

        public Builder overlayColorToBlur(int overlayColorToBlur) {
            this.overlayColorToBlur = overlayColorToBlur;
            return this;
        }

        public Builder allowFallback(boolean allowFallback) {
            this.allowFallback = allowFallback;
            return this;
        }

        public Builder asyncPolicy(@NonNull AsyncPolicy asyncPolicy) {
            this.asyncPolicy = asyncPolicy;
            return this;
        }

        public Builder debug(boolean debug) {
            this.debug = debug;
            return this;
        }

        public BlurConfig build() {
            return new BlurConfig(radius, downScaleFactor, overlayColorToBlur,
                    allowFallback, asyncPolicy, debug);
        }
    }
}
