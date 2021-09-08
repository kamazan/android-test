package com.evaneos.destinations_list.presentation

import com.evaneos.destinations_list.presentation.model.Destination
import com.evaneos.destinations_list.domain.model.Destination as DomainDestination
import kotlin.random.Random

object DestinationFixtures {
    fun getDomainDestination(id: Long = Random.nextLong(0L, 1000L)): DomainDestination {
        return DomainDestination(id, "name", "www.example.com", null, Random.nextInt(0, 5))
    }

    fun getDestination(id: Long = Random.nextLong(0L, 1000L)): Destination {
        return Destination(id, "name", "www.example.com", null, Random.nextInt(0, 5).toFloat())
    }

    fun getDomainDestinations(size: Int): List<DomainDestination> {
        return (0 until size).map { index ->
            getDomainDestination(index + 1L)
        }
    }

    fun getDestinations(size: Int): List<Destination> {
        return (0 until size).map { index ->
            getDestination(index + 1L)
        }
    }
}

