package org.samples.springbootrestsample.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletResponse;

import org.samples.springbootrestsample.domain.Version;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController("versions")
@RequestMapping("/products/{productId}/versions")
public class VersionController extends BaseController {

    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    Version create(@PathVariable("productId") UUID productId, @RequestBody Version version) {

	return version;

    }

    @RequestMapping(value = "{versionId}", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    Version get(HttpServletResponse response, @PathVariable("productId") UUID productId,
	    @PathVariable("verionsId") UUID versionId) {

	Version version = new Version();
	version.setId(versionId);
	version.setUrl("MyVersion");

	return version;

    }

    @RequestMapping(method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    List<Version> getAll(@PathVariable("productId") UUID productId) {

	Version version = new Version();
	version.setId(UUID.randomUUID());
	version.setUrl("MyVersion1");

	Version version2 = new Version();
	version2.setId(UUID.randomUUID());
	version2.setUrl("MyVersion2");

	List<Version> Versions = new ArrayList<>();
	Versions.add(version);
	Versions.add(version2);
	return Versions;

    }

    @RequestMapping(value = "{versionId}", method = RequestMethod.PUT)
    @ResponseStatus(HttpStatus.OK)
    Version putme(@PathVariable("productId") UUID productId, @PathVariable("versionId") UUID versionId,
	    @RequestBody Version modified) {

	return modified;

    }

    @RequestMapping(value = "{versionId}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void delete(@PathVariable("productId") UUID productId, @PathVariable("versionId") UUID versionId) {

    }

}
