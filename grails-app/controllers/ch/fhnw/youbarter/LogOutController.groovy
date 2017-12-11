package ch.fhnw.youbarter

class LogOutController {

    def index = {
        session.invalidate()
        redirect (uri:'/')
    }
}
