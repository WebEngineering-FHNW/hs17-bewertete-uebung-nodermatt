package ch.fhnw.youbarter

import grails.gorm.transactions.Transactional

@Transactional
class OfferService {

    /**
     * Verify if provided user is owner of passed offer
     * @param currentUser The currently logged in user
     * @param offer The offer subject to verification
     * @return boolean value indicating if user is owner of offer
     */
    def isOwner(User currentUser, Offer offer) {
        User owner = Offer.findById(offer.id).getOfferer()
        boolean isOwner = owner.equals(currentUser)
        println("current user: "+ isOwner + " is owner of: " + offer)
        return owner.equals(currentUser)
    }
}
