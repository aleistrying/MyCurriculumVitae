(() => {
    const App = {
        config: {
            baseURL: `http${false ? "s" : ""}://${"144.172.75.71"}:${"80"}/api/v1`,//"144.172.75.71",
            URLRoute: {
                getCV: (id) => { return `${App.config.baseURL}/CurriculumVitae/${id}` },
            },
        },
        htmlElements: {
            name: document.getElementById("name"),
            profesionalTitle: document.getElementById("profesionalTitle"),
            location: document.getElementById("location"),
            aboutMe: document.getElementById("aboutMe"),
            socialLinks: document.getElementById("socialLinks"),
            educations: document.getElementById("educations"),
            technicalSkills: document.getElementById("technicalSkills"),
            projects: document.getElementById("projects"),
            experiences: document.getElementById("experiences"),
        },
        init: async () => {
            let Profesional = await App.Requests.getProfesional(1);

            console.log(Profesional)
            App.draw.CV(Profesional);
        },
        templates: {
            name: (name) => {
                return name;
            },
            profesionalTitle: (profesionalTitle) => {
                return profesionalTitle;
            },
            location: (location) => {
                return location;
            },
            aboutMe: (aboutMe) => {
                return aboutMe;
            },
            socialLinks: (text, detail, pathToImage, i) => {
                if (detail.startsWith("http")) {
                    detail = `<a href="${detail}">${text} Link</a>`;
                }
                let style = document.createElement("style");
                style.innerHTML = `.logo${i}{mask:url('${pathToImage}') 50% 50%/contain no-repeat;-webkit-mask:url('${pathToImage}') 50% 50%/contain no-repeat;}`;
                document.getElementsByTagName('head')[0].appendChild(style);

                return `<li class="pop flex-row wrap justify-center align-center center mt-1" id="socialLink${i}">
                    <div class="img-icon-container flex-row justify-center"><div class="socialIcon logo${i}" ></div></div>
                    <div class="detail"><h4 class="font-normal">${text}</h4><p class="font-normal word-break">${detail}</p></div>
                </li>
                `;
            },
            technicalSkills: (categoryName, skills) => {
                let i = 0;
                let list = "";
                while (i < skills.length) {
                    list += `<li class="skill">${skills[i]}</li>`;
                    i++;
                }
                return `<div class="skills-container"> <h3 class="my-small font-bold">${categoryName}</h3>
                              <ul class="my-small flex-row wrap">${list}</ul></div>`;
            },
            projects: (description, keywords, projectName, sourceCode, tryOut) => {
                if (sourceCode.startsWith('http')) {
                    sourceCode = `<a href="${sourceCode}">Source Code</a>`;
                }
                if (tryOut.startsWith('http')) {
                    tryOut = `<a href="${tryOut}">Try Out</a>`;
                }
                let i = 0;
                let res = "";
                let list = "";
                while (i < keywords.length) {
                    if (i != keywords.length - 1) {
                        res += `<li class="inline">${keywords[i]},</li> `;
                    }
                    else {
                        res += `<li  class="inline">${keywords[i]}.</li>`;
                    }
                    i++;
                }
                list += `<ul>${res}</ul>`;
                return `<ul class="mt-1"><h3>${projectName}</h3>
                 <li class="my-small"> <ul>${list}</ul> </li>
                 <li class="my-small"><p>${description}</p></li>
                 <li class="my-small"> <div class="flex-row justify-end"><div class="link m-half">${sourceCode}</div><div class="link m-half"> ${tryOut}</div></div></li></ul>`;
            },
            experiences: (details, organizationName, position, year) => {
                let i = 0;
                let list = "";
                while (i < details.length) {
                    list += `<li class="exp-detail">${details[i]}</li>`;
                    i++;
                }
                return `<div  class="mt-1"><h3>${year} - ${organizationName}</h3>
                            <h4 class="my-small">${position}</h4>
                            <ul class="my-small">${list}</ul>
                        </div>`;
            }
            ,
            educations: (endYear, entityName, startYear, titleEarned) => {
                if (!endYear || endYear == null) {
                    endYear = "Current"
                }
                return `<div class="mt-1"><h3 class="m-small">${entityName}</h3>
                    <div class="m-small">${startYear} - ${endYear} | ${titleEarned}</div>
                </div>`;
            }

        },
        draw: {

            CV: ({
                generalInfo,
                socialLinks: { socialLinks },
                projects: { projects },
                technicalSkills: { technicalSkills },
                educations: { educations },
                experiences: { experiences }, }) => {

                console.log(
                    generalInfo,
                    socialLinks,
                    educations,
                    projects,
                    experiences,
                    technicalSkills
                );
                App.draw.GeneralInfo(generalInfo);
                App.draw.SocialLinks(socialLinks);
                App.draw.TechnicalSkills(technicalSkills);
                App.draw.Projects(projects);
                App.draw.Experiences(experiences);
                App.draw.Educations(educations);
            },
            GeneralInfo: ({ name, lastname, profesionalTitle, location, aboutMe }) => {

                App.htmlElements.name.innerHTML = App.templates.name(`${name} ${lastname}`);
                App.htmlElements.profesionalTitle.innerHTML = App.templates.profesionalTitle(profesionalTitle);
                App.htmlElements.location.innerHTML = App.templates.location(location);
                App.htmlElements.aboutMe.innerHTML = App.templates.aboutMe(aboutMe);
            },
            SocialLinks: (socialLinks) => {
                let i = 0;
                App.htmlElements.socialLinks.innerHTML = "";
                while (i < socialLinks.length) {
                    let { text, detail, pathToImage } = socialLinks[i];
                    App.htmlElements.socialLinks.innerHTML += App.templates.socialLinks(text, detail, pathToImage, i);
                    //animation by javascript maybe?
                    // let test = document.getElementById(`socialLink${i}`);
                    // // console.log(test);

                    i++;
                }
            },
            TechnicalSkills: (technicalSkills) => {
                App.htmlElements.technicalSkills.innerHTML = "";

                let i = 0;
                while (i < technicalSkills.length) {
                    let { categoryName, skills } = technicalSkills[i];
                    App.htmlElements.technicalSkills.innerHTML += App.templates.technicalSkills(categoryName, skills);
                    i++;
                }
            },
            Projects: (projects) => {
                App.htmlElements.projects.innerHTML = "";

                let i = 0;
                while (i < projects.length) {
                    let { description, keywords, projectName, sourceCode, tryOut } = projects[i];
                    App.htmlElements.projects.innerHTML += App.templates.projects(description, keywords, projectName, sourceCode, tryOut);
                    i++;
                }
            },
            Experiences: (experiences) => {
                App.htmlElements.experiences.innerHTML = "";

                let i = 0;
                while (i < experiences.length) {
                    let { details, organizationName, position, year } = experiences[i];
                    App.htmlElements.experiences.innerHTML += App.templates.experiences(details, organizationName, position, year);

                    i++;
                }
            },
            Educations: (educations) => {
                App.htmlElements.educations.innerHTML = "";

                let i = 0;
                while (i < educations.length) {
                    let { endYear, entityName, startYear, titleEarned } = educations[i];
                    App.htmlElements.educations.innerHTML += App.templates.educations(endYear, entityName, startYear, titleEarned);

                    i++;
                }
            },

        },
        Requests: {
            getProfesional: async (id) => {
                return await App.Utils.fetch(App.config.URLRoute.getCV(id));
            },
        },
        Utils: {
            fetch: async (url) => {
                // console.log(url)
                const response = await fetch(url);
                // console.log(response)
                return response.json();
            },
        },
    };
    App.init();
})();