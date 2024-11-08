package org.mathieu.sandboxdiiage12027.nativemanager

import android.content.Context
import android.media.AudioAttributes
import android.media.AudioFocusRequest
import android.media.AudioManager
import android.media.MediaPlayer
import androidx.annotation.RawRes
import org.mathieu.sandboxdiiage12027.R


class SoundManager(private val context: Context) {

    private var mediaPlayer: MediaPlayer? = null
    private val audioManager: AudioManager = context.getSystemService(Context.AUDIO_SERVICE) as AudioManager
    private val focusRequest: AudioFocusRequest

    init {
            val audioAttributes = AudioAttributes.Builder()
                .setUsage(AudioAttributes.USAGE_ASSISTANCE_SONIFICATION)
                .setContentType(AudioAttributes.CONTENT_TYPE_SONIFICATION)
                .build()

            focusRequest = AudioFocusRequest.Builder(AudioManager.AUDIOFOCUS_GAIN_TRANSIENT_MAY_DUCK)
                .setAudioAttributes(audioAttributes)
                .setAcceptsDelayedFocusGain(false)
                .setWillPauseWhenDucked(false)
                .build()
    }

    private fun playSound(@RawRes resId: Int) {
        mediaPlayer?.release()
        mediaPlayer = MediaPlayer.create(context, resId)

        mediaPlayer?.setOnCompletionListener {
            audioManager.abandonAudioFocusRequest(focusRequest)
        }

        val result = audioManager.requestAudioFocus(focusRequest)

        if (result == AudioManager.AUDIOFOCUS_REQUEST_GRANTED) {
            mediaPlayer?.start()
        }
    }

    fun playButtonClickedSound() = playSound(R.raw.button_clicked_sound)

}
